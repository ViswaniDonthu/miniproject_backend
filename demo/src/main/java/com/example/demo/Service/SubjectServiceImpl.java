package com.example.demo.Service;

import com.example.demo.Entity.Branch;
import com.example.demo.Entity.Subject;
import com.example.demo.Repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
  @Autowired
    SubjectRepo subjectrepo;
    @Override
    public Subject findBySubjectId(String subjectname, Branch branch) {
        return subjectrepo.findBySubjectNameAndBranch(subjectname,branch);
    }

}
