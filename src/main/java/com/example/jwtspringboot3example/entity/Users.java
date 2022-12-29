package com.example.jwtspringboot3example.entity;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;


@EqualsAndHashCode
@Builder
@RequiredArgsConstructor
public class Users {
    private final String email;
    private final String name;
    private final String password;
}
