package com.example.ServicioRESTTesisAutV2.service;

import com.example.ServicioRESTTesisAutV2.model.Email;
import com.example.ServicioRESTTesisAutV2.model.User;
import com.example.ServicioRESTTesisAutV2.repository.EmailRepository;
import com.example.ServicioRESTTesisAutV2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmailServiceImpl implements IEmailService{
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Email> getSentMails(String sender) {
        return emailRepository.findAll().stream().filter(email -> email.getSender()
                .equals(sender)).collect(Collectors.toList());
    }



    @Override
    public Set<Email> getInbox(String recipient) {
    return userRepository.findAll().stream().filter(user->user.getName().equals(recipient))
            .findFirst().get().getEmails();


    }


    @Override
    public String sendEmail(Email email) {
        String recipient = email.getPrimaryRecipient();


        String recipients = email.getPrimaryRecipient() + "," +  email.getCC() +  "," + email.getBCC();

        List<String> username = Arrays.asList(recipients.split(","));

        List<User> users = userRepository.findAll().stream()
                .filter(u -> username.stream()
                        .anyMatch(name -> name.equals(u.getName())))
                .toList();

        String statement = "";
        for(User user: users){
            boolean isMailRepeated = user.getEmails().stream()
                    .anyMatch(m -> ((m.getSubject().equals(email.getSubject())) && (m.getBody().equals(email.getBody())) && (m.getAttachments().equals(email.getAttachments()))));

            if(isMailRepeated){
                statement =  "This mail already exits in the receiver mailbox";
            }else{
                email.getUsers().add(user);
                emailRepository.save(email);
                statement = "Email sended";
            }
        }

        return statement;

    }
}

