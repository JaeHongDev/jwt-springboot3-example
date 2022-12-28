package com.example.jwtspringboot3example.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.example.jwtspringboot3example.config.WebSecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest({AuthController.class})
@Import(WebSecurityConfig.class)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void 토큰이_반환됩니다() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.content().string("token"));
    }

    @Test
    void 토근을_검증합니다() throws Exception {
        var token = "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoibmFtZSIsImV4cCI6MTY3MjI2MTk5NSwiaWF0IjoxNjcyMjI1OTk1LCJzY29wZSI6InRlc3QifQ.g1LUhk83bbBApHdgQ7ZO-8Q__MBu4paI-ewplYpht_tk5PMlLAMwPukFzp9ara0KOpmI-zrIyuZnmZsqybESPGJHC0C4I6Jyt9OBLfZa586DJ0aACe-Nsjujp60bVrDuPaXYFGK5FmYgW3kBgfEn8JuxTw1WehPK8X9bJmvfY-YFZ8jxsjrsBOp8-1SsmWM6tZVWac31KqelmmLU5_SIsnt3WiggbVq9f0UePzw6iJZQXaHm6bKL8y8gYVZYXxzRFLIofCfpcXYriHVUROrVZRDrXEkyq2cj1a3Q9lSWD-_VZt9qoDS5nMKyjRDQ0t3rAGhXRr9tkh5rkpA1fHTzzw";
        mockMvc.perform(MockMvcRequestBuilders.get("/token").header("authorization",token))
                .andExpect(MockMvcResultMatchers.content().string("test"));
    }
}