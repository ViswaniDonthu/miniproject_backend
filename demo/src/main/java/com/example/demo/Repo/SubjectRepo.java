package com.example.demo.Repo;


import com.example.demo.Entity.Branch;
import com.example.demo.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,Long> {
    Subject findBySubjectNameAndBranch(String subject, Branch branch);

}
