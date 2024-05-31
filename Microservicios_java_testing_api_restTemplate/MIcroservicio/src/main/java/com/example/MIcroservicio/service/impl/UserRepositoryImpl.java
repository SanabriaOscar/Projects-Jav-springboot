package com.example.MIcroservicio.service.impl;

import com.example.MIcroservicio.model.User;
import com.example.MIcroservicio.repository.UserRepository;
import com.example.MIcroservicio.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class UserRepositoryImpl  {


   /*@Autowired
    private UserRepository userRepository;



    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User findByIdUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User updateUserById(User user, Long id) {
        userRepository.save(user);
        return  user;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }*/
}
