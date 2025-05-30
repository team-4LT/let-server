package com.example.let_server.domain.auth.repository;

public interface RefreshTokenRepository {
    void save(String username, String refreshToken);

    String findByUsername(String username);

    void deleteByUsername(String username);

    Boolean existsByUsername(String username);
}
