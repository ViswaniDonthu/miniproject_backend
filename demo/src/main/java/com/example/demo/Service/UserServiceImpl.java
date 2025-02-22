package com.example.demo.Service;
import com.example.demo.Entity.User;
import com.example.demo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo repo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    // Registering a new user with encoded password
    @Override
    public User registerNewUser(User user) {
        String email = user.getEmail();
        String regex = "n(\\d{6})@rguktn\\.ac\\.in"; // Pattern for valid email

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid email format! Use 'nXXXXXX@rguktn.ac.in'");
        }

        // Encrypt password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return repo.save(user);
    }
    // Handling user login
    @Override

    public User loginUser(String email, String password) {
        // Validate email format
        String regex = "n(\\d{6})@rguktn\\.ac\\.in";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid email format! Use 'nXXXXXX@rguktn.ac.in'");
        }

        Optional<User> user = repo.findByEmail(email);

        if (user.isPresent()) {
            boolean passwordMatches = passwordEncoder.matches(password, user.get().getPassword());

            if (passwordMatches) {
                // Extract student ID (6 digits) and batch (first two digits)
                String studentId = matcher.group(1);
                String batch = studentId.substring(0, 2);

                System.out.println("Student ID: " + studentId);
                System.out.println("Batch: " + batch);
                int batchYear = Integer.parseInt("20" + batch);

                // Get the current year
                int currentYear = Year.now().getValue();

                // Calculate year difference
                int yearDifference = currentYear - batchYear;
                return user.get();
            }
            throw new RuntimeException("Invalid username or password");
        } else {
            throw new UsernameNotFoundException("User not found for email: " + email);
        }
    }

    // Get username by register ID
    @Override
    public String getUsernameByRegisterId(long register_id) {
        User register = repo.findById(register_id);
        if (register == null) {
            throw new RuntimeException("User not found for register ID: " + register_id);
        }
        return register.getUsername();
    }
    // Check if email is present in the database
    @Override
    public Boolean checkMailPresent(String mail) {
        mail = mail.trim().toLowerCase();
        Optional<User> user = repo.findByEmail(mail);
        return user.isPresent();
    }

    @Override
    public User getUserId(String email) {
        return repo.findByEmail(email).orElse(null);
    }


}
