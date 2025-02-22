package com.example.demo.Repo;

import com.example.demo.Entity.Academicyear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AcademicRepo extends JpaRepository<Academicyear, Long> {


    Academicyear findIdByAcademicYear(String year);
}

