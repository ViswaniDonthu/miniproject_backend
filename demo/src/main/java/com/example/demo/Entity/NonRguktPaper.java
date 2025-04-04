package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class NonRguktPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectName;

    private String semester;

    private String branch;

    private String academicYear;

    private String examType;

    private String fileUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private boolean isAccepted;

    // Constructors
    public NonRguktPaper() {}

    public NonRguktPaper(String subjectName, String semester, String branch, String academicYear, String examType, String fileUrl, User user, boolean isAccepted) {
        this.subjectName = subjectName;
        this.semester = semester;
        this.branch = branch;
        this.academicYear = academicYear;
        this.examType = examType;
        this.fileUrl = fileUrl;
        this.user = user;
        this.isAccepted = isAccepted;
    }

    // Getters and Setters

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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }
}
