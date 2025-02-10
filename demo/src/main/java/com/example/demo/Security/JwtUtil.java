package com.example.demo.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

import java.util.Date;

@Component
public class JwtUtil {

    // Secret key (base64 encoded)
    private final String secretKey = "no_one_is_perfect_in_this_world_remember";

    // Generate a JWT token with email as subject
    public String generateToken(String email) {
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes()); // Use a Key object for security

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours validity
                .signWith(key, SignatureAlgorithm.HS256) // Using the Key for signing
                .compact();
    }

    // Extract username (email) from the token
    public String extractUsername(String token) {
        Claims claims = getClaims(token);
        return claims != null ? claims.getSubject() : null;
    }

    // Validate if the token is correct (matches the user details) and not expired
    public boolean validateToken(String token, String userDetails) {
        return userDetails.equals(extractUsername(token)) && !isTokenExpired(token);
    }

    // Check if the token is expired
    private boolean isTokenExpired(String token) {
        Claims claims = getClaims(token);
        return claims == null || claims.getExpiration().before(new Date());
    }

    // Parse the claims from the JWT token
    private Claims getClaims(String token) {
        try {
            Key key = Keys.hmacShaKeyFor(secretKey.getBytes()); // Ensure the Key object for parsing

            return Jwts.parser()
                    .setSigningKey(key)  // Set the signing key here
                    .build()
                    .parseClaimsJws(token)   // Parse the JWT and get the Claims
                    .getBody();
        } catch (Exception e) {
            System.out.println("Invalid or expired JWT token: " + e.getMessage());
            return null;
        }
    }
}
