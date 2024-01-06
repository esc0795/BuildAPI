package com.esc.api.BuildAPI.repository;

import com.esc.api.BuildAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface USerRepository extends JpaRepository<user, Long> {
    @Override
    <S extends user> S save(S entity);
}
