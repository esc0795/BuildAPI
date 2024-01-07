package com.esc.api.BuildAPI.controller;

import com.esc.api.BuildAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.esc.api.BuildAPI.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class buildAPIController {

    private final UserService userService;

    @Autowired
    public buildAPIController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>("User successfully created", HttpStatus.CREATED);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
