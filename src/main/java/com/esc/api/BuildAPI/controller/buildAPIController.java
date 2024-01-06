package com.esc.api.BuildAPI.controller;

import com.esc.api.BuildAPI.model.User;
import com.esc.api.BuildAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class buildAPIController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody user user) {
        userRepository.save(user);
        return new ResponseEntity<>("User successfully created", HttpStatus.CREATED);
    }
}
