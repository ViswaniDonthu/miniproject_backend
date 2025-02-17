package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String branch;

    private String semester;

    private String subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_year_id")
    private Academicyear academicYear;

    // Getters and setters omitted for brevity

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        // Validate branch against allowed values
        if (isValidBranch(branch)) {
            this.branch = branch;
        } else {
            throw new IllegalArgumentException("Invalid branch value");
        }
    }

    private boolean isValidBranch(String branch) {
        // Define valid branches
        String[] validBranches = {"cse", "ece", "mech", "eee", "civil", "chemical", "mme", null};
        for (String validBranch : validBranches) {
            if (validBranch.equals(branch)) {
                return true;
            }
        }
        return false;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        // Validate semester against allowed values
        if (isValidSemester(semester)) {
            this.semester = semester;
        } else {
            throw new IllegalArgumentException("Invalid semester value");
        }
    }

    private boolean isValidSemester(String semester) {
        // Define valid semesters
        String[] validSemesters = {"sem1", "sem2"};
        for (String validSemester : validSemesters) {
            if (validSemester.equals(semester)) {
                return true;
            }
        }
        return false;
    }

    public Academicyear getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(Academicyear academicYear) {
        this.academicYear = academicYear;
    }
}
