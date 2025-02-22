package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Subject {
    @Id@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String subjectName;
    private String subjectCode;
    @ManyToOne
    private Branch branch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
