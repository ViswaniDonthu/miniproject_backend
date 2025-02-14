package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import com.example.demo.Security.JwtUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginData) throws JsonProcessingException {
        String email = loginData.getEmail();
        String password = loginData.getPassword();
        User loginObj = service.loginUser(email, password);
         System.out.println(loginObj.getUsername());
        if (loginObj != null) {
            long id = loginObj.getId();
            String token = jwtUtil.generateToken(loginObj);
            return ResponseEntity.ok(Map.of("register_id", id, "token", token, "message", "You Logged in Successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Invalid username or password."));
        }
    }

//    @PostMapping("/verify")
//    public ResponseEntity<?> verifyToken(@RequestBody Map<String, String> requestData) {
//        String token = requestData.get("token");
//        System.out.println("token"+token);
//        if (token == null || token.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "Token is required"));
//        }
//
//        String username = jwtUtil.extractUsername(token);
//        if (username != null && jwtUtil.validateToken(token, username)) {
//
//            return ResponseEntity.ok(Map.of("username", username, "message", "Token is valid"));
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid or expired token"));
//        }
//    }
@PostMapping("/verify")
public ResponseEntity<?> verifyToken(@RequestBody Map<String, String> requestData) {
    String token = requestData.get("token");
    System.out.println("Received Token: " + token);

    if (token == null || token.isEmpty()) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("message", "Token is required"));
    }

    User extractedUser = jwtUtil.extractUser(token);

    if (extractedUser != null && jwtUtil.validateToken(token, extractedUser.getEmail())) {
        return ResponseEntity.ok(Map.of(
                "id", extractedUser.getId(),
                "name", extractedUser.getUsername(),
                "email", extractedUser.getEmail(),
                "branch",extractedUser.getBranch(),
                "message", "Token is valid"
        ));
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("message", "Invalid or expired token"));
    }
}

}
