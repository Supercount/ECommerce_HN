package com.example.ecommerce.controllers.payload;

import javax.validation.constraints.Size;

public class SigninRequest {

    @Size(min = 4, max = 12)
    private String username;
    @Size(min = 6, max = 12)
    private String password;
    @Size(min = 6, max = 12)
    private String firstName;
    @Size(min = 6, max = 12)
    private String lastName;
    @Size(min = 6, max = 12)
    private String email;

    public SigninRequest() {
    }

    public SigninRequest(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
