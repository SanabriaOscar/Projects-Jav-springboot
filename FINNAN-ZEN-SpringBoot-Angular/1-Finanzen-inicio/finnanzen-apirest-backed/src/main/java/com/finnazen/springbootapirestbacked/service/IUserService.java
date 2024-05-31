package com.finnazen.springbootapirestbacked.service;

import com.finnazen.springbootapirestbacked.dto.UserDto;
import com.finnazen.springbootapirestbacked.model.User;

import java.util.List;

public interface IUserService {
    List<User> listAllUsers();
    User saveUser(UserDto userDto);
    User findByIdUser(Long id);
    User updateUserById(User user, Long id);
    void deleteUserById(Long id);
    User findByEmail(String email);
}
