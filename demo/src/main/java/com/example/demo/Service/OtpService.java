package com.example.demo.Service;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class OtpService {

    // In-memory OTP storage
    private final Map<String, String> otpStorage = new ConcurrentHashMap<>();
    private final Map<String, Long> otpTimestamp = new ConcurrentHashMap<>();

    private static final int OTP_EXPIRATION_TIME = 5 * 60 * 1000;  // OTP expires in 5 minutes
    private static final int OTP_LENGTH = 6;

    // Generate OTP for a given email
    public String generateOtp(String email) {
        if (email == null || email.isEmpty()) {
            return "null";
        }

//        String regex = "n(\\d{6})@rguktn\\.ac\\.in";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(email);
//
//        if (!matcher.matches()) {
//            return "false";
//            // throw new IllegalArgumentException("Invalid email format! Use 'nXXXXXX@rguktn.ac.in'");
//        }
        String otp = generateRandomOtp();
        otpStorage.put(email, otp);

        // Record the timestamp of OTP generation
        otpTimestamp.put(email, System.currentTimeMillis());

        // Schedule OTP expiration after 5 minutes
        Executors.newSingleThreadScheduledExecutor().schedule(() -> {
            otpStorage.remove(email);
            otpTimestamp.remove(email);
        }, OTP_EXPIRATION_TIME, TimeUnit.MILLISECONDS);

        return otp;
    }

    // Verify the OTP for a given email
    public boolean verifyOtp(String email, String otp) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email must not be null or empty.");
        }

        String storedOtp = otpStorage.get(email);
        Long storedTimestamp = otpTimestamp.get(email);

        // Check if OTP exists and if it's expired
        if (storedOtp == null || storedTimestamp == null) {
            return false;  // OTP does not exist
        }

        // Check if OTP is expired
        if (System.currentTimeMillis() - storedTimestamp > OTP_EXPIRATION_TIME) {
            otpStorage.remove(email);
            otpTimestamp.remove(email);
            return false;  // OTP expired
        }
        System.out.println(storedOtp+" "+otp);
        // Check if OTP matches
        return storedOtp.equals(otp);
    }

    // Helper method to generate a random 6-digit OTP
    private String generateRandomOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);  // Generate a 6-digit OTP
        return String.valueOf(otp);
    }
}