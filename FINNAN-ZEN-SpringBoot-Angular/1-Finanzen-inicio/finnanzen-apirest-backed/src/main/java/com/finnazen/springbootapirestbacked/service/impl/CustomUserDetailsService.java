package com.finnazen.springbootapirestbacked.service.impl;

import com.finnazen.springbootapirestbacked.model.PermisosUserRol;
import com.finnazen.springbootapirestbacked.model.User;
import com.finnazen.springbootapirestbacked.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Forzar la carga de permisosUserRoles
        Set<PermisosUserRol> roles = user.getPermisosUserRoles();
        roles.size(); // Esto debería forzar la carga de los roles si no están cargados.

        // Verificar que los datos esenciales no sean nulos
        if (user.getEmail() == null || user.getPassword() == null || roles.isEmpty()) {
            throw new UsernameNotFoundException("User data is incomplete");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                roles.stream()
                        .map(permisosUserRol -> new SimpleGrantedAuthority(permisosUserRol.getRol().getName()))
                        .collect(Collectors.toList()));
    }
}