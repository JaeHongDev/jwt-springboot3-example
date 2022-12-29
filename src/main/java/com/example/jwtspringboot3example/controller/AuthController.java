package com.example.jwtspringboot3example.controller;

import com.example.jwtspringboot3example.payload.request.SignupUserDto;
import com.example.jwtspringboot3example.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupUserDto signupUserDto) {
        return ResponseEntity.ok(authService.signup(signupUserDto));
    }

    @GetMapping("/test")
    public String sayHello() {
        return "hello";
    }
}
