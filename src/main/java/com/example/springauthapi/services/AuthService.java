package com.example.springauthapi.services;

import com.example.springauthapi.models.User;
import com.example.springauthapi.repositories.UserRepository;
import com.example.springauthapi.requests.LoginRequest;
import com.example.springauthapi.requests.RegisterRequest;
import com.example.springauthapi.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public ApiResponse register(RegisterRequest registerRequest) {
        try {
            // check for email exist
            Optional<User> exist = userRepository.findByEmail(registerRequest.getEmail());
            if (exist.isPresent()) throw new Exception("Sorry, email already exists.");

            User user = new User(registerRequest.getEmail());
            user.setFirstName(registerRequest.getFirstName());
            user.setLastName(registerRequest.getLastName());
            user.setPassword(registerRequest.getPassword());
            user.setStatus(true);
            user.setCreatedAt(new Date());
            user = userRepository.save(user);

            return ApiResponse.success(user);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    public ApiResponse login(LoginRequest loginRequest) {
        try {
            // check for email
            Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
            if (user.isEmpty()) throw new Exception("email/password is invalid.");
            if (!user.get().getPassword().equals(loginRequest.getPassword())) throw new Exception("email/password is invalid.");

            Map<String, Object> data = new HashMap<>();
            data.put("id", user.get().getId());
            data.put("firstName", user.get().getFirstName());
            data.put("lastName", user.get().getLastName());
            data.put("email", user.get().getEmail());

            return ApiResponse.success(data);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }
}
