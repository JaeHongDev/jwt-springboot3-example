package com.example.jwtspringboot3example.infrastructure;


import com.example.jwtspringboot3example.entity.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TokenProvider {

    private final ObjectMapper objectMapper;
    private final JwtEncoder jwtEncoder;
    private final JwtDecoder jwtDecoder;

    private final long expiry = 36000L;

    public String generateToken(final Users data) {

        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject("subject")
                .claim("email", data.getEmail())
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public String decode(String accessToken) {
        var claims = jwtDecoder.decode(accessToken).getClaims();
        return claims.get("email").toString();
    }
}
