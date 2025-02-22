package com.example.demo.Service;

import com.example.demo.Entity.Branch;
import com.example.demo.Repo.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    BranchRepo branchrepo;
    @Override
    public Branch findBranchId(String branch, int semester) {
     return branchrepo.findByBranchAndSemester(branch,semester);

    }
}
