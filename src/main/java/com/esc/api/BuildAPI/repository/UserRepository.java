package com.esc.api.BuildAPI.repository;

import com.esc.api.BuildAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}