package com.example.demo.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.QuestionPaper;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface QuestionPaperRepo extends JpaRepository<QuestionPaper, Long>, JpaSpecificationExecutor<QuestionPaper> {




}
