package io.leraloro.mainservice.service;

import io.leraloro.mainservice.model.Role;
import io.leraloro.mainservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleService(
            RoleRepository roleRepository) {

        this.roleRepository = roleRepository;

    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
