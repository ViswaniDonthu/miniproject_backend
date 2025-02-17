package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class QuestionPaper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subjects subject;

    @Column(nullable = false)
    private String examType;

    private String fileUrl;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="uploaded_id")
    private User uploadedBy;

    // Getters and setters omitted for brevity

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        // Restricting exam types to specific values
        if (isValidExamType(examType)) {
            this.examType = examType;
        } else {
            throw new IllegalArgumentException("Invalid exam type");
        }
    }

    private boolean isValidExamType(String examType) {
        // Define valid exam types
        String[] validTypes = {"mid1", "mid2", "mid3", "sem", "at1", "at2", "at3", "at4"};
        for (String type : validTypes) {
            if (type.equals(examType)) {
                return true;
            }
        }
        return false;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public User getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(User uploadedBy) {
        this.uploadedBy = uploadedBy;
    }
}
