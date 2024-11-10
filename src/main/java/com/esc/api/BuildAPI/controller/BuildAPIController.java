package com.esc.api.BuildAPI.controller;

import com.esc.api.BuildAPI.model.dto.UserRequestDTO;
import com.esc.api.BuildAPI.model.dto.UserResponseDTO;
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
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDto) {
        User user = userService.saveUser(userRequestDto);
        return new UserResponseDTO(user.getId(), user.getUser_name(), user.getEmail());
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDto) {
        User existingUser = userService.getUserById(id);

        if(existingUser != null) {
            existingUser.setEmail(userRequestDto.getEmail());
            existingUser.setUser_name(userRequestDto.getUser_name());
            User updatedUser = userService.updateUser(existingUser);
            UserResponseDTO responseDTO = new UserResponseDTO(updatedUser.getId(), updatedUser.getUser_name(),
                    updatedUser.getEmail());
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        User existingUser = userService.getUserById(id);

        if(existingUser != null) {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
