package com.example.jwtspringboot3example.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.example.jwtspringboot3example.payload.request.SignupUserDto;
import com.example.jwtspringboot3example.repository.AuthRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AuthServiceTest {
    @InjectMocks
    private AuthService authService;
    @Mock
    private AuthRepository authRepository;


    @Test
    void 사용자가_생성되면_id_가_담겨져있는_dto를_반환한다() {
        given(authRepository.save(any())).willReturn(1L);
        var signupDto = SignupUserDto.builder()
                .email("email")
                .name("name")
                .password("password")
                .build();

        var actual = authService.signup(signupDto).userId();
        var expected = 1L;
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}