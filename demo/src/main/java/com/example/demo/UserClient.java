package com.example.demo;


import com.example.demo.Model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@FeignClient(name = "user-service")  // <- this name should match spring.application.name of user-service
public interface UserClient {

    @PostMapping("/auth/verifyToken")     // <- this path is from user-service controller
    //UserDTO verifyUser(String token);
    UserDTO verifyUser(@RequestBody Map<String, String> body);

@PostMapping("/auth/verify")  // Adjust path if needed
ResponseEntity<Map<String, Object>> verifyToken(@RequestBody Map<String, String> requestData);
    @PostMapping("/auth/verify_admin")
    ResponseEntity<Map<String, Object>>verifyAdminToken(@RequestBody Map<String, String> requestData);
    @PostMapping("/user/saveUser")
    UserDTO saveUser(@RequestBody UserDTO user);
    @GetMapping("/user/byEmail")
    Optional<UserDTO> getUserByEmail(@RequestParam("email") String email);
    @GetMapping("/auth/extractUser")
    UserDTO extractUserByUserService(String token);
    @GetMapping("/user/getDetails")
    UserDTO getUserDetails(@RequestParam("id") Long id);
}
