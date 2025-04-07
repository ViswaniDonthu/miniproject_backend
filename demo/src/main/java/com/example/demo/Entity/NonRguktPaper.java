package com.example.demo.Entity;

import com.example.demo.Model.UserDTO;
import jakarta.persistence.*;

@Entity
public class NonRguktPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectName;

    private Integer semester;

    private String branch;

    private String academicYear;

    private String examType;

    private String fileUrl;
    @Column(name = "uploaded_id")
    private Long uploadedBy;

    @Transient
    private UserDTO user;

    private boolean isAccepted;
     private String collageName;
    // Constructors
    public NonRguktPaper() {}

    public NonRguktPaper(String subjectName, Integer semester, String branch, String academicYear, String examType, String fileUrl, UserDTO user, boolean isAccepted) {
        this.subjectName = subjectName;
        this.semester = semester;
        this.branch = branch;
        this.academicYear = academicYear;
        this.examType = examType;
        this.fileUrl = fileUrl;
        this.user = user;
        this.isAccepted = isAccepted;
    }

    public String getCollageName() {
        return collageName;
    }

    public void setCollageName(String collageName) {
        this.collageName = collageName;
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

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public Long getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(Long uploadedBy) {
        this.uploadedBy = uploadedBy;
    }
}
