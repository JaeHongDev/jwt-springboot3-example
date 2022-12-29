package com.example.jwtspringboot3example.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.jwtspringboot3example.entity.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AuthRepositoryImplTest {
    private AuthRepository authRepository;
    @BeforeEach
    void setUp() {
        this.authRepository = new AuthRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
        this.authRepository = null;
    }

    @Test
    void 사용자가_정상적으로_등록됩니다(){
        var unSavedUser = Users.builder().email("email").name("name").password("password").build();
        var savedUserId = authRepository.save(unSavedUser);
        var savedUser = authRepository.findById(savedUserId);
        assertThat(savedUser).isEqualTo(savedUser);
    }
}