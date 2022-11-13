package com.example.springauthapi.requests;

import com.example.springauthapi.models.User;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RegisterRequest {
    @NotBlank(message = "First Name is required.")
    private String firstName;
    @NotBlank(message = "Last Name is required.")
    private String lastName;
    @NotBlank(message = "Email is required.")
    @Email(message = "Email is invalid.")
    private String email;
    @NotBlank(message = "Password")
    private String password;
}
