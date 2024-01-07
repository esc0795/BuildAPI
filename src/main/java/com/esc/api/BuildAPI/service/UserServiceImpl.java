package com.esc.api.BuildAPI.service;

import com.esc.api.BuildAPI.exception.CustomException;
import com.esc.api.BuildAPI.model.User;
import com.esc.api.BuildAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        try {
            userRepository.save(user);
        } catch(Exception e) {
            e.printStackTrace();
            throw new CustomException("An error occurred while saving users.");
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("An error occurred while fetching users.");
        }
    }
}
