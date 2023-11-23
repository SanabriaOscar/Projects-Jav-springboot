package com.example.MIcroservicio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private Long idUser;
    @NotBlank(message = "esto no puede ser nulo")
    private  String name;
}
