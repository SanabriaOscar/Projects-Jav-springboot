package com.example.ServicioRESTTesisAutV2.controller;

import com.example.ServicioRESTTesisAutV2.Dto.UserDto;
import com.example.ServicioRESTTesisAutV2.model.Role;
import com.example.ServicioRESTTesisAutV2.model.User;
import com.example.ServicioRESTTesisAutV2.service.RoleServiceImpl;
import com.example.ServicioRESTTesisAutV2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserControllerREST {

    @Autowired
    private UserServiceImpl userService;
     @Autowired
    private RoleServiceImpl rolService;

    @GetMapping(value = "/users")
    public List<User> listUsersC(){
        return  userService.ListAllUsers();
    }

    @PostMapping(value = ("/users/new"))
    public String saveUserC( @RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return "user registered susccefull";
    }
    @GetMapping(value = "/users/{id}")
    public User listUserById(@PathVariable("id")int id){
        return  userService.findUserByid(id);
    }


   @PutMapping("/{rolId}/users/{userId}")
    User addRolToUser(
            @PathVariable Integer rolId,
            @PathVariable Integer userId
    ) {
        User user = userService.findUserByid(userId);
        Role role = rolService.findRoleByid(rolId);

        user.getRoles().add(role);
        return userService.saveUserUpdate(user);

    }

    @PutMapping(value = "/users/{id}")
    public User updateUserC(@RequestBody UserDto userDto ,@PathVariable("id") Integer id){
        User userUpdate =  userService.findUserByid(id);
        userUpdate.setName(userDto.getName());
        userUpdate.setLastname(userDto.getLastname());
        userUpdate.setIdentification(userDto.getIdentification());
        userUpdate.setEmail(userDto.getEmail());
        userUpdate.setPassword(userDto.getPassword());
        userUpdate.setDirection(userDto.getDirection());
        userUpdate.setPostalCode(userDto.getPostalCode());
        userUpdate.setState(userDto.getState());
        userUpdate.setCity(userDto.getCity());
        userUpdate.setCountry(userDto.getCountry());


        return userUpdate;
    }

    @DeleteMapping(value = "/users/{id}")

    public  String deleteuUserC(@PathVariable("id") Integer id){
        userService.deleteuser(id);
        return "user deleted";
    }


}
