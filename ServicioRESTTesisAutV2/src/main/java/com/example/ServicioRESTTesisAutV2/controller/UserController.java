package com.example.ServicioRESTTesisAutV2.controller;

import com.example.ServicioRESTTesisAutV2.Dto.UserDto;
import com.example.ServicioRESTTesisAutV2.model.User;
import com.example.ServicioRESTTesisAutV2.service.IUserService;
import com.example.ServicioRESTTesisAutV2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//@PreAuthorize("hasRole('ADMIN')")


@Controller
@RequestMapping("/new")
public class UserController {
//        @Autowired
//    private UserServiceImpl userService;
//
//
//    @ModelAttribute("user")
//    public UserDto returnNewUserDto() {
//        return new UserDto();
//    }
//
//    @GetMapping
//    public String showFormAdUser() {
//        return
//                "new";
//    }
//
//    @PostMapping
//    public String registrarCuentaDeUsuario(@ModelAttribute("user") UserDto userDto) {
//        userService.saveUser(userDto);
//        return "redirect:/new?exit";
//    }
//
//
//    @GetMapping("users/{id}")
//    public  User saveByIdC(@PathVariable int id){
//        return userService.findUserByid(id);
//    }
//
//    @PutMapping("users/{id}")
//    public  UserDto UpdateUser(@RequestBody UserDto userDto, @PathVariable int id) {
//        User   userUpdate=  userService.findUserByid( id);
//        userUpdate.setName(userDto.getName());
//        userUpdate.setLastname(userDto.getLastname());
//        userUpdate.setIdentification(userDto.getIdentification());
//        userUpdate.setPassword(userDto.getPassword());
//        userUpdate.setDirection(userDto.getDirection());
//        userUpdate.setCity(userDto.getCity());
//        userUpdate.setState(userDto.getState());
//        userUpdate.setCountry(userDto.getCountry());
//        userUpdate.setPostalCode(userDto.getPostalCode());
//        userService.saveUser(new UserDto());
//        return userDto;
//
//    }
//    @PreAuthorize("hasRole('ADMIN')")
//
//    @DeleteMapping("/user/{id}")
//    public void deleteUserC(@PathVariable int id){
//        userService.deleteuser(id);
//    }
//

}
