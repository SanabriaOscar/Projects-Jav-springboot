package com.example.pruebaNTTDATA.controller;

import com.example.pruebaNTTDATA.exceptions.RecordAlreadyExits;
import com.example.pruebaNTTDATA.model.User;
import com.example.pruebaNTTDATA.service.UserServiceImpl;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> listAllUserC(){
        return userService.listAllUsers();
    }
    @GetMapping("/searchUser")
    public ResponseEntity<?> searchUserC(@Param("filter") String filter) throws Exception {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.searchUser(filter));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""
                    +e.getMessage()+"\"}"));
        }
    }

    @PostMapping("/users/add")
    public String saveUserC(@RequestBody User user){
        Optional<User> savedUser = Optional.ofNullable(userService.findByIdUser(user.getId()));
        if(savedUser.isPresent()){
            throw new RecordAlreadyExits("User already exist:" + user.getId());
        }
        userService.saveUser(user);
        return "User saved sussesfull";
    }
    @GetMapping("/users/{id}")
    public User listUserByIdC(@PathVariable int id) {
        return userService.findByIdUser(id);
    }
    @PutMapping("/users/edit/{id}")
    public User updateUserByIdC(@PathVariable int id, @RequestBody User user) {
        User userUpdate=userService.findByIdUser(id);
        userUpdate.setName(user.getName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setAddress(user.getAddress());
        userUpdate.setPhoneNumber(user.getPhoneNumber());
        userUpdate.setTask(user.getTask());
        userService.saveUser(userUpdate);
        return userUpdate;
    }
    @DeleteMapping("/users/delete/{id}")
    public String deleteUserC(@PathVariable int id){
        userService.deleteUser(id);
        return "User deleted sussesfull";
    }
}
