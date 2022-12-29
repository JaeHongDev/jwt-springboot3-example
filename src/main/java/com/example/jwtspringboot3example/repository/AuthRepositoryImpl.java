package com.example.jwtspringboot3example.repository;

import com.example.jwtspringboot3example.entity.Users;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;


@Repository
public class AuthRepositoryImpl implements AuthRepository {
    private final Map<Long, Users> usersMap = new LinkedHashMap<>();
    private long id = 1L;

    @Override
    public Long save(Users user) {
        this.usersMap.put(id, user);
        return id++;
    }

    @Override
    public Optional<Users> findById(Long userId) {
        return Optional.ofNullable(this.usersMap.get(userId));
    }
}
