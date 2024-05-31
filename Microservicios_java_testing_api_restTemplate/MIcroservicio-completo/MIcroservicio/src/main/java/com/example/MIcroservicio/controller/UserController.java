package com.example.MIcroservicio.controller;

import com.example.MIcroservicio.model.User;
import com.example.MIcroservicio.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class UserController {

   /* @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public List<User> getAllUsersC(){
        return userService.listAllUsers();

    }
    @PostMapping("/users")
    public User saveUser(User user){
        userService.saveUser(user);
        return user;
    }
    @GetMapping("/users/{id}")
    public User findByIdUser(Long id){
        return userService.findByIdUser(id);
    }
    @PutMapping("users/{id}")
    public User updateUserById(User user, Long id){
        User userUpdated=userService.findByIdUser(id);
        userUpdated.setName(user.getName());
        userService.updateUserById(userUpdated, id);
        return userUpdated;
    }
    @DeleteMapping("/users/{id}")
    public void deleteUserById(Long id){
        userService.deleteUserById(id);
    }*/
}
