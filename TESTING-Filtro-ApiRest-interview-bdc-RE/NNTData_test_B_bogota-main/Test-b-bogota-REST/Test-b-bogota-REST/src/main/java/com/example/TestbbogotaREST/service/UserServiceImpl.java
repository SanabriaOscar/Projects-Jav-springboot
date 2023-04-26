package com.example.TestbbogotaREST.service;

import com.example.TestbbogotaREST.exceptions.ResourceNotFoundException;
import com.example.TestbbogotaREST.model.User;
import com.example.TestbbogotaREST.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

@Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        Optional<User> savedUser= userRepository.findById(user.getId());
        if(savedUser.isPresent()){
            new ResourceNotFoundException("User already exist with given email:" + user.getId());
        }
        return userRepository.save(user);
    }

    @Override
    public User findByIdUser(int id) {
        return userRepository.findById(id).get();
    }



    @Override
    public User deleteUser(int id) {
        userRepository.deleteById(id);
        return null;
    }

    @Override
    public List<User> searchUser(String identicationFilter) {


        if (identicationFilter != null) {
            return userRepository.findUserByIdentification(identicationFilter);
        }
        return null;
    }

}

