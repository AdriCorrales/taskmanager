package com.adrian.taskmanager.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = false)
public class UserCreationRequest {

    @NotBlank(message = "Username is required")
    @Size(min = 1, message = "Name shouldn't be empty")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 1, message = "Password shouldn't be empty")
    private String password;

    public UserCreationRequest() {
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
