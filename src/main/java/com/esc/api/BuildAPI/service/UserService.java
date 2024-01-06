package com.esc.api.BuildAPI.service;

import com.esc.api.BuildAPI.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void saveUser(User user);
}
