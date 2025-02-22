package com.example.demo.Service;

import com.example.demo.Entity.Academicyear;
import com.example.demo.Repo.AcademicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademicServiceImpl implements AcademicService {
   @Autowired
    AcademicRepo academicrepo;
    @Override
    public Academicyear findYearId(String year) {
       return academicrepo.findIdByAcademicYear(year);
    }
}
