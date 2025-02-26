package com.example.demo.Controller;

import com.example.demo.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:5173")
@Controller
public class UserQueryEmailController {
    @Autowired
    private EmailService emailService;
  @PostMapping("/queryemail")
    public ResponseEntity<?> queryemail(@RequestBody  Map<String, String> data){
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
}
