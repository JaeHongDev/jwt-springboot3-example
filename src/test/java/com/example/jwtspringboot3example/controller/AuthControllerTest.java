package com.example.jwtspringboot3example.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.example.jwtspringboot3example.payload.response.SignupResponseDto;
import com.example.jwtspringboot3example.service.AuthService;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(AuthController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith({MockitoExtension.class})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AuthControllerTest {

    @MockBean
    private AuthService authService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void 실행테스트() throws Exception {
        mockMvc.perform(get("/api/v1/auth/test"))
                .andExpect(content().string("hello"));
    }


    @Test
    void 회원가입을_위한_사용자요청을_보내고_성공하면_응답_엔티티에_아이디를_넣어서_전달해줍니다() throws Exception {
        given(authService.signup(any())).willReturn(new SignupResponseDto(1L));
        mockMvc.perform(post("/api/v1/auth/signup")
                        .content("""
                                {
                                    "email":"email",
                                    "password":"password",
                                    "name":"name"
                                }
                                """).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("userId").value("1"));

    }


}