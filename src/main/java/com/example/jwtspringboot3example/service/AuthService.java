package com.example.jwtspringboot3example.service;

import com.example.jwtspringboot3example.entity.Users;
import com.example.jwtspringboot3example.infrastructure.TokenProvider;
import com.example.jwtspringboot3example.payload.request.LoginRequestDto;
import com.example.jwtspringboot3example.payload.request.SignupUserDto;
import com.example.jwtspringboot3example.payload.response.ResponseTokenDto;
import com.example.jwtspringboot3example.payload.response.SignupResponseDto;
import com.example.jwtspringboot3example.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final TokenProvider tokenProvider;
    private final AuthRepository authRepository;

    public ResponseTokenDto login(LoginRequestDto loginRequestDto) {
        Users user = authRepository.findUserByEmail(loginRequestDto.email());
        return new ResponseTokenDto(tokenProvider.generateToken(user));
    }

    public SignupResponseDto signup(final SignupUserDto signupUserDto) {
        return new SignupResponseDto(this.authRepository.save(signupUserDto.toEntity()));
    }

    public ResponseTokenDto reissueToken(String accessToken) {
        return new ResponseTokenDto(
                tokenProvider.generateToken(
                        this.authRepository.findUserByEmail(tokenProvider.decode(accessToken))
                )
        );
    }
}
