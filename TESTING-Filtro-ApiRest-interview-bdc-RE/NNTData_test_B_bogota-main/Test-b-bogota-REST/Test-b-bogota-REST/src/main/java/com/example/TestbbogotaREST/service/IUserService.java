package com.example.TestbbogotaREST.service;

import com.example.TestbbogotaREST.model.User;

import java.util.List;

public interface IUserService {
    public List<User> listAllUsers();
    public User saveUser(User user);
    public User findByIdUser(int id);
    public User deleteUser(int id);
    List<User> searchUser(String identicationFilter) ;
}
