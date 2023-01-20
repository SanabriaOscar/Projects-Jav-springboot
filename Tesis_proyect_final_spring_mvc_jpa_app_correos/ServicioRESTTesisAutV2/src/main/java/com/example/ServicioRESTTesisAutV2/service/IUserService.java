package com.example.ServicioRESTTesisAutV2.service;

import com.example.ServicioRESTTesisAutV2.Dto.UserDto;
import com.example.ServicioRESTTesisAutV2.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    public List<User> ListAllUsers();
    public  User saveUser(UserDto userDto);
    public User saveUserUpdate(User user);
    public  User findUserByid(int id);
    public  void deleteuser(int id);

}
