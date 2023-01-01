package com.example.jwtspringboot3example.repository;

import com.example.jwtspringboot3example.entity.Users;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository {
    Long save(Users users);

    Optional<Users> findById(Long userId);

    Users findUserByEmail(String email);
}
