package com.example.ServicioRESTTesisAutV2.Dto;


import com.example.ServicioRESTTesisAutV2.model.User;

public class UserDto{
    private int id;
    private String name;
    private String lastname;
    private String identification;
    private String email;
    private String password;
    private String direction;
    private String postalCode;
    private String city;
    private String state;
    private String country;

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

    public UserDto() {
    }

    public UserDto(String name, String lastname, String identification, String email, String password, String direction, String postalCode, String city, String state, String country) {
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
    }
}
