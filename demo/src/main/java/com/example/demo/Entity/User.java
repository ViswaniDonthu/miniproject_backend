////package com.example.demo.Entity;
////
////import jakarta.persistence.*;
////
////import java.util.ArrayList;
////import java.util.List;
////
////@Entity
////public class User {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////    private String username;
////    private String email;
////    private String password;
////    private String branch;
////    private String resetToken;
////    private List<Rewards> rewards = new ArrayList<>();
////    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
////    public List<Rewards> getRewards() {
////        return rewards;
////    }
////
////    public void setRewards(List<Rewards> rewards) {
////        this.rewards = rewards;
////    }
////
////    public String getResetToken() {
////        return resetToken;
////    }
////
////    public void setResetToken(String resetToken) {
////        this.resetToken = resetToken;
////    }
////
////    public String getEmail() {
////        return email;
////    }
////
////    public void setEmail(String email) {
////        this.email = email;
////    }
////
////    public Long getId() {
////        return id;
////    }
////
////    public void setId(Long id) {
////        this.id = id;
////    }
////
////    public String getUsername() {
////        return username;
////    }
////
////    public void setUsername(String username) {
////        this.username = username;
////    }
////
////    public String getPassword() {
////        return password;
////    }
////
////    public void setPassword(String password) {
////        this.password = password;
////    }
////
////    public String getBranch() {
////        return branch;
////    }
////
////    public void setBranch(String branch) {
////        this.branch = branch;
////    }
////}
//package com.example.demo.Entity;
//
//import jakarta.persistence.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String username;
//    private String email;
//    private String password;
//    private String branch;
//    private String resetToken;
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Rewards> rewards = new ArrayList<>();
//
//    public List<Rewards> getRewards() {
//        return rewards;
//    }
//
//    public void setRewards(List<Rewards> rewards) {
//        this.rewards = rewards;
//    }
//
//    public String getResetToken() {
//        return resetToken;
//    }
//
//    public void setResetToken(String resetToken) {
//        this.resetToken = resetToken;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getBranch() {
//        return branch;
//    }
//
//    public void setBranch(String branch) {
//        this.branch = branch;
//    }
//}
package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String branch;
    private String resetToken;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Rewards> rewards = new ArrayList<>();

    public List<Rewards> getRewards() {
        return rewards;
    }

    public void setRewards(List<Rewards> rewards) {
        this.rewards = rewards;
    }

    public User() {

    }

    public User(Long id, String username, String email, String password, String branch, String resetToken, List<Rewards> rewards) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.branch = branch;
        this.resetToken = resetToken;
        this.rewards = rewards;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
