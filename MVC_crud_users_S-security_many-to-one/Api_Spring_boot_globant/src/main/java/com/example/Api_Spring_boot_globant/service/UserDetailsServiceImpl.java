package com.example.Api_Spring_boot_globant.service;


import com.example.Api_Spring_boot_globant.model.Role;
import com.example.Api_Spring_boot_globant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       com.example.Api_Spring_boot_globant.model.User userApp=
                userRepository.findByEmail(email).orElseThrow(() -> new
                        UsernameNotFoundException("No existe usuario"));

        List ListRoles = new ArrayList();
        for (Role authority: userApp.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getNombre());
            ListRoles.add(grantedAuthority);
        }

        UserDetails user = (UserDetails) new User(userApp.getEmail(), userApp.getPassword(), ListRoles);
        return user;
    }
}
