package com.example.demo.Repo;



import com.example.demo.Entity.User;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    //Register findByEmail(String email);
    User findById(long register_id);

    Optional<User> findByEmail(String email);
    Optional<User> findByResetToken(String resetToken);
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.password = :newPassword WHERE u.email = :email")
    void updatePasswordByEmail(@Param("email") String email, @Param("newPassword") String newPassword);
}