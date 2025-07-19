package com.example.votingwebsite.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.votingwebsite.model.User;
import com.example.votingwebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class WelcomController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getMethodName() {
        return "welcome to the voting website!";
    }

    @PostMapping("/registUser")
    public ResponseEntity<Object> registUser(@RequestBody User user) {

        try {
            userService.registerUser(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body("Error registering user: " + e.getMessage());
        }
    }

}
