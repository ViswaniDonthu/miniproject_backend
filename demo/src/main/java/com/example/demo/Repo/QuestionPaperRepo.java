package com.example.demo.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.QuestionPaper;

public interface QuestionPaperRepo extends JpaRepository<QuestionPaper, Long> {

}

