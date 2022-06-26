package com.example.ensapay.request;

import javax.validation.constraints.NotBlank;

public class ChangePasswordRequestAgent {

    @NotBlank
    private String username;

    @NotBlank
    private String newPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
