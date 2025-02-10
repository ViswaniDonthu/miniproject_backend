package com.example.demo.Service;
import com.example.demo.Entity.User;
import com.example.demo.Repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PasswordResetService {

    private final UserRepo registerRepository;

    public PasswordResetService(UserRepo registerRepository) {
        this.registerRepository = registerRepository;
    }

    // Generate and store the reset token
    public String generateResetToken(String email) {
        Optional<User> user = registerRepository.findByEmail(email);
        if (user.isPresent()) {
            String token = UUID.randomUUID().toString();
            User register = user.get();
            register.setResetToken(token);
            registerRepository.save(register);
            return token;
        }
        return null; // User not found
    }

    // Validate the reset token
    public User validateResetToken(String token) {
        Optional<User> user = registerRepository.findByResetToken(token);
        return user.orElse(null); // Return user if token is valid
    }

    // Reset the user's password
    public void resetPassword(User user, String newPassword) {
        user.setPassword(newPassword);
        user.setResetToken(null); // Clear the reset token after password reset
        registerRepository.updatePasswordByEmail(user.getEmail(), newPassword);
    }
}
