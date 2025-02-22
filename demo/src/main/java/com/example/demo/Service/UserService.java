package com.example.demo.Service;

import com.example.demo.Entity.User;

public interface UserService {
    User registerNewUser(User user);
    User loginUser(String email, String password);
    String getUsernameByRegisterId(long register_id);
    Boolean checkMailPresent(String mail);

    User getUserId(String email);
}