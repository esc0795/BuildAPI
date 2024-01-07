package com.esc.api.BuildAPI.service;

import com.esc.api.BuildAPI.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void saveUser(User user);

    List<User> getAllUsers();
}
