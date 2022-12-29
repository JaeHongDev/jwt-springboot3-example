package com.example.jwtspringboot3example.repository;

import com.example.jwtspringboot3example.entity.Users;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;


public class AuthRepositoryImpl implements AuthRepository{
    private long id = 1L;
    private final Map<Long, Users> usersMap = new LinkedHashMap<>();
    @Override
    public Long save(Users user) {
        this.usersMap.put(id, user);
        return id;
    }

    @Override
    public Optional<Users> findById(Long userId) {
        return Optional.ofNullable(this.usersMap.get(userId));
    }
}
