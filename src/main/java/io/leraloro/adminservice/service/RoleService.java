package io.leraloro.adminservice.service;

import io.leraloro.adminservice.model.Role;
import io.leraloro.adminservice.repository.RoleRepository;
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
