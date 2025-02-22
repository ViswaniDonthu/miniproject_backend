package com.example.demo.Service;

import com.example.demo.Entity.Branch;

public interface BranchService {
    Branch findBranchId(String branch, int semester);
}
