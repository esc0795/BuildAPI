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
public class BuildAPIController {

    private final UserService userService;

    @Autowired
    public BuildAPIController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>("User successfully created", HttpStatus.CREATED);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<String> createUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User existingUser = userService.getUserById(id);

        if(existingUser != null) {
            existingUser.setUser_name(updatedUser.getUser_name());
            existingUser.setEmail(updatedUser.getEmail());
            userService.updateUser(existingUser);
            return new ResponseEntity<>("User successfully updated", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        User existingUser = userService.getUserById(id);

        if(existingUser != null) {
            userService.deleteUser(id);
            return new ResponseEntity<>("User successfully deleted", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
