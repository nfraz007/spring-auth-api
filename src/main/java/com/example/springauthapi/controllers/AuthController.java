package com.example.springauthapi.controllers;

import com.example.springauthapi.models.User;
import com.example.springauthapi.repositories.UserRepository;
import com.example.springauthapi.requests.LoginRequest;
import com.example.springauthapi.requests.RegisterRequest;
import com.example.springauthapi.services.AuthService;
import com.example.springauthapi.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
        ApiResponse apiResponse = authService.register(registerRequest);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        ApiResponse apiResponse = authService.login(loginRequest);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }
}
