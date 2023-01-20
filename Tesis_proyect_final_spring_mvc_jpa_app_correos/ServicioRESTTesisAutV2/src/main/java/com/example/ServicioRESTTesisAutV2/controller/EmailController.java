package com.example.ServicioRESTTesisAutV2.controller;

import com.example.ServicioRESTTesisAutV2.model.Email;
import com.example.ServicioRESTTesisAutV2.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class EmailController {
    @Autowired
    private EmailServiceImpl emailService;

    @PutMapping("/mails/send")
    public Email sendMails(@RequestBody Email email){
       emailService.sendEmail(email);
        return email;
    }

    @GetMapping("/mails/send/{sender}")
    public List<Email> getSentMails(@PathVariable String sender){
        return emailService.getSentMails(sender);
    }

    @GetMapping("/mails/inbox/{recipient}")
    public Set<Email> getInbox(@PathVariable String recipient){
        return emailService.getInbox(recipient);
    }

}