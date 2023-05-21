package com.registration.mf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.registration.mf.service.RegistrationService;

@RestController
@RequestMapping("/registration")
@CrossOrigin
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PutMapping("/user")
    @ResponseBody
    public ResponseEntity<String> registerUser(
            @RequestParam String username,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String password,
            @RequestParam String email) {

        // Check if the username already exists
        if (registrationService.isUserExists(username) == 1) {
            return ResponseEntity.ok("Username already exists");
        }

        // Register the user
        registrationService.insertUser(username, firstName, lastName, password, email);

        return ResponseEntity.ok("User registered successfully");
    }
}
