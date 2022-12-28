package com.example.jwtspringboot3example.entity;


import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class Users {
    private final String email;
    private final String name;
    private final String password;
}
