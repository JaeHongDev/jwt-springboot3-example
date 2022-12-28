package com.example.jwtspringboot3example.controller;

import com.example.jwtspringboot3example.payload.request.SignupUserDto;
import com.example.jwtspringboot3example.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/")
    public void createUserRequest(@RequestBody SignupUserDto signupUserDto){
        authService.signup(signupUserDto);
    }
}
