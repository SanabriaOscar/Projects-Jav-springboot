package com.example.TestbbogotaREST.controller;

import com.example.TestbbogotaREST.model.User;
import com.example.TestbbogotaREST.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users/searchUser")
    public ResponseEntity<?> searchUserC(@Param("identicationFilter") String filter) throws Exception {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.searchUser(filter));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""
                    +e.getMessage()+"\"}"));
        }
    }


    @GetMapping("/users")
    public ResponseEntity<User> listAllUsers() {
        List<User> users = userService.listAllUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @PostMapping("/users/add")
    public ResponseEntity<User> saveUserC(@RequestBody User user){
     try {
         userService.saveUser(user);
     }catch (Exception e){
         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
     }
        return new ResponseEntity<User>(user, null, HttpStatus.CREATED);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> listUserByIdC(@PathVariable int id) {
        User user= userService.findByIdUser(id);
        if (null == user) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @PutMapping("/users/edit/{id}")
    public ResponseEntity<User> updateUserByIdC(@PathVariable int id, @RequestBody User user) {
       try {
           User userUpdate = userService.findByIdUser(id);
           if (null == userUpdate) {
               return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
           }
           userUpdate.setFirstName(userUpdate.getFirstName());
           userUpdate.setSecondName(user.getSecondName());
           userUpdate.setFirstLastName(user.getFirstLastName());
           userUpdate.setSecondLastName(user.getSecondLastName());
           userUpdate.setPhoneNumber(user.getPhoneNumber());
           userUpdate.setIdentification(user.getIdentification());
           userUpdate.setAddress(user.getAddress());
           userService.saveUser(userUpdate);
           return new ResponseEntity<User>(userUpdate, HttpStatus.OK);
       }catch (Exception e){
            new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
           e.printStackTrace();
       }
        return (ResponseEntity<User>) ResponseEntity.ok();
    }
    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<User> deleteUserC(@PathVariable int id){
     User user= userService.findByIdUser(id);
        if (null == user) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
         userService.deleteUser(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

}
