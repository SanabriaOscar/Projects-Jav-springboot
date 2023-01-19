package com.example.ServicioRESTTesisAutV2.model;

import com.example.ServicioRESTTesisAutV2.Dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
//@Builder
@Entity
@Table(name = "users", uniqueConstraints ={@UniqueConstraint(columnNames = {"email"})})
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20)
    private String lastname;
    @Column(nullable = false, length = 30,unique = true)
    private String identification;
    @Column( length = 40)
    private String email;
    @Column( length = 100)
    private String password;
    @Column(nullable = false, length = 60)
    private String direction;
    @Column(nullable = false, length = 20)
    private String postalCode;
    @Column(nullable = false, length = 20)
    private String city;
    @Column(nullable = false, length = 20)
    private String state;
    @Column(nullable = false, length = 20)
    private String country;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns =@JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Collection<Role> roles;

    @ManyToMany(mappedBy = "users")
    private Set<Email> emails = new HashSet<>();

    public User() {

    }

    public User(int id, String name, String lastname, String identication, String email, String password, String bogota, String pais, String s3) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public User(int id, String name, String lastname, String identification, String email, String password, String direction, String postalCode, String city, String state, String country, Collection<Role> roles) {
        super();
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.identification = identification;
        this.email = email;
        this.password = password;
        this.direction = direction;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.roles = roles;
    }

    public User(String name, String lastname, String identification, String email, String password, String direction, String postalCode, String city, String state, String country, Collection<Role> roles) {
        super();
        this.name = name;
        this.lastname = lastname;
        this.identification = identification;
        this.email = email;
        this.password = password;
        this.direction = direction;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.roles = roles;
    }


}
