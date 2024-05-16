package com.finnazen.springbootapirestbacked.service;



import com.finnazen.springbootapirestbacked.model.User;

import java.util.List;

public interface IUserService {
    public List<User> listAllUsers();
    public User saveUser(User user);
    public User findByIdUser(Long id);
    public User UpdateUserById(User user, Long id);
    public  void deleteUserById(Long id);
}
