package io.leraloro.mainservice.service;

import io.leraloro.mainservice.model.AdminEmail;
import io.leraloro.mainservice.model.Role;
import io.leraloro.mainservice.model.User;
import io.leraloro.mainservice.repository.RoleRepository;
import io.leraloro.mainservice.repository.UserRepository;
import io.leraloro.mainservice.util.QueueUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    private RabbitTemplate rabbitTemplate;
    private Queue accountCreatedQueue;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder,
                       @Qualifier("accountCreated") Queue accountCreatedQueue,
                       RabbitTemplate rabbitTemplate) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.accountCreatedQueue = accountCreatedQueue;
        this.rabbitTemplate = rabbitTemplate;
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public User saveUser(User user) {

        String defaultPassword = "default";

        user.setPassword(defaultPassword);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActivated(true);
        user.setCreatedOn(new Date());
        user.setUpdatedOn(new Date());
        Optional<Role> userRole = roleRepository.findById(user.getRole());
        user.setRoles(new HashSet<>(Arrays.asList(userRole.get())));

        sendUserAccountEmailMessage(AdminEmail.builder()
                .receiver(user.getUsername())
                .subject("Account Creation.")
                .message("Your account have been successfully created with the password: " + defaultPassword)
                .build());

        return userRepository.save(user);
    }

    public void sendUserAccountEmailMessage(AdminEmail message) {
        QueueUtils adminEmail = new QueueUtils<AdminEmail>();
        rabbitTemplate.convertAndSend(
                accountCreatedQueue.getName(), adminEmail.serializeToJson(message, logger));
    }

}
