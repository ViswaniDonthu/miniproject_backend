package com.example.demo.Repo;
import com.example.demo.Entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Long> {
   Branch findByBranchAndSemester(String branch, int semester);
   // List<Branch> findByBranchAndSemester(String branch, int semester);

}