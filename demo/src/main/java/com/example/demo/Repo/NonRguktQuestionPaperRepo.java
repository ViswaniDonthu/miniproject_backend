package com.example.demo.Repo;

import com.example.demo.Entity.NonRguktPaper;
import com.example.demo.Entity.RejectedPapers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NonRguktQuestionPaperRepo extends JpaRepository<NonRguktPaper,Long>, JpaSpecificationExecutor<NonRguktPaper> {
    Page<NonRguktPaper> findAllByIsAcceptedFalse(Pageable pageable);
}
