package com.finnazen.springbootapirestbacked.service.impl;


import com.finnazen.springbootapirestbacked.exceptions.ResourceNotFoundException;
import com.finnazen.springbootapirestbacked.model.Role;
import com.finnazen.springbootapirestbacked.repository.RoleRepository;
import com.finnazen.springbootapirestbacked.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements IRoleService {

    @Autowired
    RoleRepository roleRepository;


    @Override
    public List<Role> listAllRoles() {

        return roleRepository.findAll();
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findByIdRole(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if (!role.isPresent()) {
            throw new ResourceNotFoundException("No se encontró el rol con el id: " + id);
        }
        return  role.get();
    }

    @Override
    public Role UpdateRoleById(Role role, Long id) {
        Optional<Role> roleObject = roleRepository.findById(id);
        if (!roleObject.isPresent()) {
            throw new ResourceNotFoundException("No se encontró el rol con el id: " + id);
        }
        role.setIdRol(id);
        return roleRepository.save(role);
    }

    @Override
    public Role deleteRoleById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if (!role.isPresent()) {
            throw new ResourceNotFoundException("No se encontró el rol con el id: " + id);
        }
        roleRepository.delete(role.get());
        return null;
    }
}
