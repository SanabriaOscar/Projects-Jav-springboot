package com.example.ServicioRESTTesisAutV2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@Builder
@Entity
@Table(name = "emails")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sender;
    private String primaryRecipient;
    @Column(nullable = true)
    private String cC;
    //@JsonIgnore
    @Column(nullable = true)
    private String bCC;
    private String subject;
    @Column(nullable = true)
    private String body;
    @Column(nullable = true)
    private String attachments;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "emailsUsers",joinColumns = @JoinColumn(name = "email_id", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    Set<User> users = new HashSet<>();

}
