package com.example.ECommerceHN.Controller.payload;

import javax.validation.constraints.Size;

public class SigninRequest {

    @Size(min = 4, max = 12)
    private String username;
    @Size(min = 6, max = 12)
    private String password;

    public SigninRequest() {
    }

    public SigninRequest(String username, String password) {
        this.username = username;
        this.password = password;
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
}
