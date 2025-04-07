package com.example.demo.Model;
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String branch;
    private int place;
    private Long contributions;

    public UserDTO() {
        this.contributions = 0L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Long getContributions() {
        return contributions;
    }

    public void setContributions(Long contributions) {
        this.contributions = contributions;
    }
}
