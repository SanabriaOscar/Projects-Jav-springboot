package com.example.Api_Spring_boot_globant.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usuarios", uniqueConstraints ={@UniqueConstraint(columnNames = {"identification"})})
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20)
    private String lastname;
    @Column(nullable = false, length = 30,unique = true)
    private String identification;
    @Column(nullable = false, length = 60,unique = true)
    private String email;
    @Column( length = 120)
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
    private Set<Role> roles;

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User() {
    }

    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User(String name, String lastname, String identification, String email, String password, String direction, String postalCode, String city, String state, String country, Set<Role> roles) {
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
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", identification='" + identification + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", direction='" + direction + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", roles=" + roles +
                '}';
    }
}
