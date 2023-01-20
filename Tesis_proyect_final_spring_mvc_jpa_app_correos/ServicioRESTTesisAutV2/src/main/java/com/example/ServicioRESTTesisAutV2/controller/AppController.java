package com.example.ServicioRESTTesisAutV2.controller;

import com.example.ServicioRESTTesisAutV2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private IUserService servicioService;

    @GetMapping("/login")
    public String login() {
        return
                "login";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(Model model) {
        model.addAttribute("users", servicioService.ListAllUsers());
        return "index";
    }

}