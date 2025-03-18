package com.example.demo.Repo;


import com.example.demo.Entity.Academicyear;
import com.example.demo.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.QuestionPaper;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface QuestionPaperRepo extends JpaRepository<QuestionPaper, Long>, JpaSpecificationExecutor<QuestionPaper> {

    Page<QuestionPaper> findAll(Pageable pageable);
    boolean existsByAcademicyearAndExamTypeAndSubjectAndIsaccepted(Academicyear academicyear, String examType, Subject subject,Boolean isaccepted);


}
