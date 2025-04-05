package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;
    @PostMapping("/register")
    public ResponseEntity<?> addNewUser(@RequestBody User user) {
        Boolean present=service.checkMailPresent(user.getEmail());
        if(present){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        User addUser = service.registerNewUser(user);
        if (addUser != null) {
            return ResponseEntity.ok(Map.of("message", "New User has been successfully registered."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "Registration failed."));
        }
    }

    @GetMapping("/getUserName/{register_id}")
    public String getUserName(@PathVariable long register_id) {
        return service.getUsernameByRegisterId(register_id);
    }

    @PostMapping("/emailcheck")
    public ResponseEntity<?> checkEmail(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        Boolean present = service.checkMailPresent(email);
        return ResponseEntity.ok(Map.of("present", present));
    }
}
