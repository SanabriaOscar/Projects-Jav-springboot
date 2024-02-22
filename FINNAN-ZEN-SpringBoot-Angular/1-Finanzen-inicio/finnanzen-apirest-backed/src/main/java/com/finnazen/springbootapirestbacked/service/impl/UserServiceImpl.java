package com.finnazen.springbootapirestbacked.service.impl;

import com.finnazen.springbootapirestbacked.exceptions.ResourceNotFoundException;
import com.finnazen.springbootapirestbacked.model.User;
import com.finnazen.springbootapirestbacked.repository.UserRepository;
import com.finnazen.springbootapirestbacked.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
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
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new ResourceNotFoundException("No se encontró el usuario con el id: " + id);
        }
        return  user.get();
    }

    @Override
    public User UpdateUserById(User user, Long id) {
        Optional<User> userSearch = userRepository.findById(id);
        if (!userSearch.isPresent()) {
            throw new ResourceNotFoundException("No se encontró el usuario con el id: " + id);
        }
        user.setIdUser(id);
    return  userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new ResourceNotFoundException("No se encontró el usuario con el id: " + id);
        }
        userRepository.delete(user.get());
    }
}
