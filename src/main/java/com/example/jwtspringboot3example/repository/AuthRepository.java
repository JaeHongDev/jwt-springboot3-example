package com.example.jwtspringboot3example.repository;

import com.example.jwtspringboot3example.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository {
    Users save(Users users);
}
