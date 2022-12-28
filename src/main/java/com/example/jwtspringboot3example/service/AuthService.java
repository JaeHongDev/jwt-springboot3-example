package com.example.jwtspringboot3example.service;

import com.example.jwtspringboot3example.entity.Users;
import com.example.jwtspringboot3example.payload.request.SignupUserDto;
import com.example.jwtspringboot3example.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public void signup(final SignupUserDto signupUserDto){
        var savedUser = this.authRepository.save(signupUserDto.toEntity());
    }

}
