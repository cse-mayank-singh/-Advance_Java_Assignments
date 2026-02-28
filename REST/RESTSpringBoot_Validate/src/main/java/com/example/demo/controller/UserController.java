package com.example.demo.controller;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        // Normally, save to DB. Here, just return success for demo
        return ResponseEntity.ok("User created successfully: " + user.getFullName());
    }
}