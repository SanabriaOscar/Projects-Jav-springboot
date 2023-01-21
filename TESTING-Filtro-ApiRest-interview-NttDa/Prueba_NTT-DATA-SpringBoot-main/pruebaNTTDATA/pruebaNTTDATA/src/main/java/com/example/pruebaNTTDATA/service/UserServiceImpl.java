package com.example.pruebaNTTDATA.service;

import com.example.pruebaNTTDATA.model.User;
import com.example.pruebaNTTDATA.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements IUserService{
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
    public User findByIdUser(int id) {
      return   userRepository.findById(id).get();   }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> searchUser(String filter) {

        if (filter != null) {
            return userRepository.searchUser(filter);
        }
        return null;
    }


}
