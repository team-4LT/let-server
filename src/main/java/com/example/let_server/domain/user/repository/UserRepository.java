package com.example.let_server.domain.user.repository;

import com.example.let_server.domain.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    List<User> findAll();
}
