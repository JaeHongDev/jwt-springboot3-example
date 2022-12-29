package com.example.jwtspringboot3example.controller;

import com.example.jwtspringboot3example.payload.request.SignupUserDto;
import com.example.jwtspringboot3example.service.AuthService;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController("/api/v1/auth")
public class AuthController {
    private final AuthService authService;
 /*   private final JwtDecoder jwtDecoder;
    private final JwtEncoder jwtEncoder;


    @GetMapping ("/")
    public String getToken(){
        Instant now = Instant.now();
        long expiry = 36000L;
        // @formatter:off
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject("name")
                .claim("scope", "test")
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    @GetMapping("/token")
    public String decodeToken(@RequestHeader("authorization") String header){
        log.info(header);
        return jwtDecoder.decode(header).getClaims().get("scope").toString();
    }
*/
    @PostMapping("/signup")
    public String signup(@RequestBody SignupUserDto signupUserDto){
        authService.signup(signupUserDto);
        return "signup";
    }
}
