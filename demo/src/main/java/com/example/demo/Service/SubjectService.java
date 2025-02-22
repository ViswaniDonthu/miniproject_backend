package com.example.demo.Service;

import com.example.demo.Entity.Branch;
import com.example.demo.Entity.Subject;

public interface SubjectService {
    Subject findBySubjectId(String subjectname, Branch branch);
}
