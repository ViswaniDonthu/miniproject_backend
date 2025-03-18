package com.example.demo.Controller;
import com.example.demo.Service.EmailService;
import com.example.demo.Service.OtpService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private OtpService otpService;

    @Autowired
    private UserService userService;
    // Endpoint to send OTP via email
    @PostMapping("/sendemail")
    public ResponseEntity<?> sendEmail(@RequestBody Map<String, String> payload) {
        try {
            String email = payload.get("email");
            System.out.println("Sending email to: " + email);

            // Generate OTP for the user
            String otp = otpService.generateOtp(email);
              System.out.println("otp"+otp);
            // Send OTP via email (assuming emailService is already configured)
            if(!Objects.equals(otp, "false")) {
                emailService.sendSimpleEmail(email, "OTP Verification", "Your OTP is: " + otp);

                return ResponseEntity.ok(Map.of("ok",true,"message", "OTP has been successfully sent to registered email."));
            }
            else if(otp.equals("null")){
                return ResponseEntity.ok(Map.of("ok",true,"message","enter email"));
            }else{
                return ResponseEntity.ok(Map.of("ok",true,"message", "please use collage mail"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "Failed to send OTP to registered email."));
        }
    }

    // Endpoint to verify OTP
    @PostMapping("/otpverify")
    public ResponseEntity<?> otpVerify(@RequestBody Map<String, String> otpObj) {
        String email = otpObj.get("email");
        String otp = otpObj.get("otp");
        System.out.println("Verifying OTP");
        // Verify the OTP for the user
        boolean isOtpValid = otpService.verifyOtp(email, otp);
        System.out.println(isOtpValid);
        if (isOtpValid) {
            return ResponseEntity.ok(Map.of("success", true));
        } else {
            return ResponseEntity.ok(Map.of("success", false));
        }
    }

}
