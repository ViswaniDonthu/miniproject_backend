package com.example.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class AdminLoginService {
    private String adminusername="projectadmin@gmail.com";
    private String adminpassword="projectpassword";

    public String getAdminusername() {
        return adminusername;
    }

    public void setAdminusername(String adminusername) {
        this.adminusername = adminusername;
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }
}
