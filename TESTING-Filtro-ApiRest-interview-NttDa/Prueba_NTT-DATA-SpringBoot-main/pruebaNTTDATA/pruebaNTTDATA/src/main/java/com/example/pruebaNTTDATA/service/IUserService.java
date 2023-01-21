package com.example.pruebaNTTDATA.service;

import com.example.pruebaNTTDATA.model.User;

import java.util.List;

public interface IUserService {
    public List<User> listAllUsers();
    public User saveUser(User user);
    public User findByIdUser(int id);
    public void deleteUser(int id);
    List<User> searchUser(String filter) ;
}
