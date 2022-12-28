package com.example.jwtspringboot3example.payload.request;


import com.example.jwtspringboot3example.entity.Users;
import lombok.RequiredArgsConstructor;

public record SignupUserDto(String email, String password, String name) {

    public Users toEntity(){
        return Users.builder()
                .email(email)
                .password(password)
                .name(name).build();
    }
}
