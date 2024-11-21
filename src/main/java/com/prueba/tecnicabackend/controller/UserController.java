package com.prueba.tecnicabackend.controller;

import com.prueba.tecnicabackend.models.User;
import com.prueba.tecnicabackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<?> getUser(
            @RequestParam String type,
            @RequestParam int numberDoc) {

        if (!type.equals("C") && !type.equals("P")) {
            return ResponseEntity.badRequest().body("Invalid document type.");
        }

        Optional<User> user = userService.getUser(type, numberDoc);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(404).body("User not found.");
        }
    }
}

