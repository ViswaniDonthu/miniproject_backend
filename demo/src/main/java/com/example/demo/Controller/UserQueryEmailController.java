package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Security.JwtUtil;
import com.example.demo.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins="*")
@Controller
public class UserQueryEmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private JwtUtil jwtUtil;
  @PostMapping("/queryemail")
    public ResponseEntity<?> queryemail(@RequestHeader("Authorization") String token,@RequestBody  Map<String, String> data){
        User u=verifyUser(token.replace("Bearer ", ""));
        if(u==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message","please login"));
        }
      try{
          String email = data.get("email");
          String username=data.get("username");
          String message=data.get("message");
          System.out.println("Sending email to: " + email+" "+username);
          emailService.sendSimpleEmail("chanduchintalapudi9@gmail.com","message/query from"+username,message);
          return ResponseEntity.ok(Map.of("message", "Thank you for your inputs."));
      } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                  .body(Map.of("message", "Failed to send ,please try again."));
      }


  }
    public User verifyUser(String token) {
        if (token == null || token.isEmpty()) {
            return null;
        }

        User extractedUser = jwtUtil.extractUser(token);

        if (extractedUser != null && jwtUtil.validateToken(token, extractedUser.getEmail())) {
            return extractedUser;  // Return user if valid
        } else {
            return null; // Return null if token is invalid

        }
    }
}
