package com.example.ServicioRESTTesisAutV2.service;

import com.example.ServicioRESTTesisAutV2.Dto.UserDto;
import com.example.ServicioRESTTesisAutV2.model.Role;
import com.example.ServicioRESTTesisAutV2.model.User;
import com.example.ServicioRESTTesisAutV2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> ListAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(UserDto userDto) {
        User user=new User(userDto.getName(), userDto.getLastname(),
                userDto.getIdentification(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()),
                userDto.getDirection(), userDto.getPostalCode(), userDto.getCity(),
                userDto.getState(),userDto.getCountry(), Arrays.asList(new Role("USER"))
        );
       return userRepository.save(user);
    }

    @Override
    public User saveUserUpdate(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User findUserByid(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteuser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("User o password invalid");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), mapearAutoridadesRoles(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
