package com.example.jwtspringboot3example.service;

import com.example.jwtspringboot3example.payload.request.SignupUserDto;
import com.example.jwtspringboot3example.payload.response.SignupResponseDto;
import com.example.jwtspringboot3example.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public SignupResponseDto signup(final SignupUserDto signupUserDto){
        return new SignupResponseDto(this.authRepository.save(signupUserDto.toEntity()));
    }

}
