package com.example.jwtspringboot3example.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@EqualsAndHashCode
@Builder
@RequiredArgsConstructor
public class Users {
    private final String email;
    private final String name;

    @JsonIgnore
    private final String password;

    public boolean sameEmail(String email) {
        return this.email.equals(email);
    }
}
