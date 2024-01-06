package com.esc.api.BuildAPI.controller;

import com.esc.api.BuildAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.esc.api.BuildAPI.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/users")
public class buildAPIController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>("User successfully created", HttpStatus.CREATED);
    }
}
