package com.example.ServicioRESTTesisAutV2.service;

import com.example.ServicioRESTTesisAutV2.model.Email;

import java.util.List;
import java.util.Set;

public interface IEmailService {
    public List<Email> getSentMails(String sender);
    public String sendEmail(Email email);
    public Set<Email> getInbox(String recipient);
}
