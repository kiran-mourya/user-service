package com.example.user.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class JwtUtility {
    private final String SECRET = "my-secret-key-my-secret-key-my-secret-key";

    List<String> roles = List.of("USER");
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", "USER")   // ✅ ADD THIS
                .setIssuedAt(new Date())
                //.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 5)) // 5 min
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .compact();
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public boolean validateToken(String token) {
        try {
            //getClaims(token);
            extractRoles(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public Object extractRoles(String token) {
        Claims claims = getClaims(token);
        return claims.get("role");
    }
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
