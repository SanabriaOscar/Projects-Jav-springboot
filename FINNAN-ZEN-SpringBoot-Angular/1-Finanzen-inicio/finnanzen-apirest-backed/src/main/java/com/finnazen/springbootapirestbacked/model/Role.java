package com.finnazen.springbootapirestbacked.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@Entity
@AllArgsConstructor
@Table(name = "roles")
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    @Column(nullable = false)
    private  String name;
    @JsonIgnore
    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY)
    private List<PermisosUserRol> permisosUserRoles;

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PermisosUserRol> getPermisosUserRoles() {
        return permisosUserRoles;
    }

    public void setPermisosUserRoles(List<PermisosUserRol> permisosUserRoles) {
        this.permisosUserRoles = permisosUserRoles;
    }
}
