package com.esc.api.BuildAPI.service;

import com.esc.api.BuildAPI.model.User;
import com.esc.api.BuildAPI.model.dto.UserRequestDTO;
import com.esc.api.BuildAPI.model.dto.UserResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User saveUser(UserRequestDTO userRequestDto);

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(User user);

    void deleteUser(Long id);
}
