package com.esc.api.BuildAPI.service;

import com.esc.api.BuildAPI.exception.CustomException;
import com.esc.api.BuildAPI.model.User;
import com.esc.api.BuildAPI.model.dto.UserRequestDTO;
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
    public User saveUser(UserRequestDTO userRequestDto) {
        try {
            User user = new User();
            user.setUser_name(userRequestDto.getUser_name());
            user.setEmail(userRequestDto.getEmail());
            return userRepository.save(user);
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

    @Override
    public User getUserById(Long id){
        try{
            return userRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("An error occurred while searching users.");
        }
    }

    @Override
    public User updateUser(User user) {
        try {
            return userRepository.save(user);
        } catch(Exception e) {
            e.printStackTrace();
            throw new CustomException("An error occurred while saving users.");
        }
    }

    @Override
    public void deleteUser(Long id) {
        try{
            userRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("An error occurred while deleting user.");
        }
    }
}
