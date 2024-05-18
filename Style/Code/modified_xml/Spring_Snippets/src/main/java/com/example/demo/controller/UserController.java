package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.CustomUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for user registration and login endpoints.
 */
@RestController
public class UserController {

    private final CustomUserDetailsService userDetailsService;

    /**
     * Constructs a new UserController with the given CustomUserDetailsService.
     *
     * @param userDetailsService the service for user authentication and registration.
     */
    public UserController(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     * Registers a new user in the system.
     *
     * @param user the User to register.
     * @return a ResponseEntity containing the registered User.
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User savedUser = userDetailsService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
