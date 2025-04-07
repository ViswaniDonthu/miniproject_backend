package com.example.demo.Repo;

import com.example.demo.Entity.NonRguktPaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NonRguktQuestionPaperRepo extends JpaRepository<NonRguktPaper,Long>, JpaSpecificationExecutor<NonRguktPaper> {

}
