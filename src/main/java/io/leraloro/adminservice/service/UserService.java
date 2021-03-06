package io.leraloro.adminservice.service;

import io.leraloro.adminservice.model.EmailMessage;
import io.leraloro.adminservice.model.Role;
import io.leraloro.adminservice.model.User;
import io.leraloro.adminservice.repository.RoleRepository;
import io.leraloro.adminservice.repository.UserRepository;
import io.leraloro.adminservice.util.QueueUtils;
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
    private Queue emailNotification;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder,
                       @Qualifier("email.notification") Queue emailNotification,
                       RabbitTemplate rabbitTemplate) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.emailNotification = emailNotification;
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

        sendUserAccountEmailMessage(EmailMessage.builder()
                .receiver(user.getUsername())
                .subject("Account Creation.")
                .message("Your account have been successfully created with the password: " + defaultPassword)
                .build());

        return userRepository.save(user);
    }

    public void sendUserAccountEmailMessage(EmailMessage message) {
        QueueUtils adminEmail = new QueueUtils<EmailMessage>();
        rabbitTemplate.convertAndSend(
                emailNotification.getName(), adminEmail.serializeToJson(message, logger));
    }

}
