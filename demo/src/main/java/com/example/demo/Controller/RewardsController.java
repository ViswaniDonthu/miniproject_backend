package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rewards")
public class RewardsController {
    @Autowired
    private UserRepo userrepo;
    @GetMapping
    public ResponseEntity<?> fetchRewards(){
        List<User> r=  userrepo.findByContributionsGreaterThanOrderByContributionsDesc(0);
        return ResponseEntity.ok().body(r);
    }
}
