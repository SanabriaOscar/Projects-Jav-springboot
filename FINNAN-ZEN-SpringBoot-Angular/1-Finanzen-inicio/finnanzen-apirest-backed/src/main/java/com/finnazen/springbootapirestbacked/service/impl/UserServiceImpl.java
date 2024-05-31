package com.finnazen.springbootapirestbacked.service.impl;

import com.finnazen.springbootapirestbacked.dto.UserDto;
import com.finnazen.springbootapirestbacked.exceptions.ResourceNotFoundException;
import com.finnazen.springbootapirestbacked.model.PermisosUserRol;
import com.finnazen.springbootapirestbacked.model.Role;
import com.finnazen.springbootapirestbacked.model.User;
import com.finnazen.springbootapirestbacked.repository.RoleRepository;
import com.finnazen.springbootapirestbacked.repository.UserRepository;
import com.finnazen.springbootapirestbacked.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> listAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User saveUser(UserDto userDto) {
        try {
            User user = new User();
            user.setName(userDto.getName());
            user.setLastname(userDto.getLastname());
            user.setIdentification(userDto.getIdentification());
            user.setEmail(userDto.getEmail());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            Role userRole = roleRepository.findByName("USER")
                    .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
            PermisosUserRol permisosUserRol = new PermisosUserRol();
            permisosUserRol.setCreateAt(new Date());
            permisosUserRol.setUser(user);
            permisosUserRol.setRol(userRole);
            user.setPermisosUserRoles((Set<PermisosUserRol>) Collections.singletonList(permisosUserRol));
            return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User findByIdUser(Long id) {
        try {
            return userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró el usuario con el id: " + id));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User updateUserById(User user, Long id) {
        try {
            User existingUser = userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró el usuario con el id: " + id));
            user.setIdUser(id);
            return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteUserById(Long id) {
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró el usuario con el id: " + id));
            userRepository.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User findByEmail(String email) {
        try {
            return userRepository.findByEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
