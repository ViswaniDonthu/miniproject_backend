////package com.example.demo.Security;
////
////import com.example.demo.Entity.User;
////import com.fasterxml.jackson.core.JsonProcessingException;
////import com.fasterxml.jackson.databind.ObjectMapper;
////import io.jsonwebtoken.Claims;
////import io.jsonwebtoken.Jwts;
////import io.jsonwebtoken.SignatureAlgorithm;
////import io.jsonwebtoken.security.Keys;
////import org.springframework.stereotype.Component;
////
////import java.security.Key;
////
////import java.util.Date;
////
////@Component
////public class JwtUtil {
////
////    // Secret key (base64 encoded)
////    private final String secretKey = "no_one_is_perfect_in_this_world_remember";
////
////    // Generate a JWT token with email as subject
////    public String generateToken(User user) throws JsonProcessingException {
////        Key key = Keys.hmacShaKeyFor(secretKey.getBytes()); // Use a Key object for security
////        String userJson = new ObjectMapper().writeValueAsString(user);
////        return Jwts.builder()
////                .setSubject(userJson)
////                .setIssuedAt(new Date())
////                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours validity
////                .signWith(key, SignatureAlgorithm.HS256) // Using the Key for signing
////                .compact();
////    }
////
////    // Extract username (email) from the token
////    public String extractUsername(String token) {
////        Claims claims = getClaims(token);
////        return claims != null ? claims.getSubject() : null;
////    }
////
////    // Validate if the token is correct (matches the user details) and not expired
////    public boolean validateToken(String token, String userDetails) {
////        return userDetails.equals(extractUsername(token)) && !isTokenExpired(token);
////    }
////
////    // Check if the token is expired
////    private boolean isTokenExpired(String token) {
////        Claims claims = getClaims(token);
////        return claims == null || claims.getExpiration().before(new Date());
////    }
////
////    // Parse the claims from the JWT token
////    private Claims getClaims(String token) {
////        try {
////            Key key = Keys.hmacShaKeyFor(secretKey.getBytes()); // Ensure the Key object for parsing
////
////            return Jwts.parser()
////                    .setSigningKey(key)  // Set the signing key here
////                    .build()
////                    .parseClaimsJws(token)   // Parse the JWT and get the Claims
////                    .getBody();
////        } catch (Exception e) {
////            System.out.println("Invalid or expired JWT token: " + e.getMessage());
////            return null;
////        }
////    }
////}
//package com.example.demo.Security;
//
//import com.example.demo.Model.UserDTO;
//import com.example.demo.UserClient;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//import java.util.Date;
//
//@Component
//public class JwtUtil {
//     @Autowired
//     private UserClient userClient;
//    // Secret key (at least 32 characters for HS256)
//    private final String secretKey = "no_one_is_perfect_in_this_world_remember";
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    // ✅ Generate JWT token with full user details
////    public String generateToken(User user) {
////        try {
////            Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
////            String userJson = objectMapper.writeValueAsString(user);
////
////            return Jwts.builder()
////                    .setSubject(userJson) // Store user JSON in subject
////                    .setIssuedAt(new Date())
////                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours validity
////                    .signWith(key, SignatureAlgorithm.HS256)
////                    .compact();
////        } catch (Exception e) {
////            throw new RuntimeException("Error generating token", e);
////        }
////    }
////
////    // ✅ Extract full User object from token
//    public UserDTO extractUser(String token) {
//        try {
//            Claims claims = getClaims(token);
//            if (claims == null) {
//                return null;
//            }
//
//            String userJson = claims.getSubject();  // Extract stored JSON
//            return objectMapper.readValue(userJson, UserDTO.class); // Convert JSON to User object
//        } catch (Exception e) {
//            throw new RuntimeException("Error extracting user from token", e);
//        }
//    }
//
////    // ✅ Extract email (username) from the User object in the token
//    public String extractUsername(String token) {
//        UserDTO user = userClient.extractUserByUserService(token);
//        return user != null ? user.getEmail() : null;
//    }
////
////    // ✅ Validate if the token is correct & not expired
//    public boolean validateToken(String token, String email) {
//        UserDTO user = extractUser(token);
//        return user != null && email.equals(user.getEmail()) && !isTokenExpired(token);
//    }
////
////    // Check if the token is expired
//    private boolean isTokenExpired(String token) {
//        Claims claims = getClaims(token);
//        return claims == null || claims.getExpiration().before(new Date());
//    }
//
//    // ✅ Parse the claims from the JWT token
//    private Claims getClaims(String token) {
//        try {
//            Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
//            return Jwts.parser()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(token)
//                    .getBody();
//        } catch (Exception e) {
//            System.out.println("Invalid or expired JWT token: " + e.getMessage());
//            return null;
//        }
//    }
//}
