package com.example.demo.Repo;

import com.example.demo.Entity.RejectedPapers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RejectedPaperRepo extends JpaRepository<RejectedPapers,Long> {
    Page<RejectedPapers> findAll(Pageable pageable);
    RejectedPapers findById(long Id);
}
