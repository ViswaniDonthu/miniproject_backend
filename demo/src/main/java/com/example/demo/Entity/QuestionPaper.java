package com.example.demo.Entity;

import com.example.demo.Model.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
//@Table( uniqueConstraints = @UniqueConstraint(columnNames = {"examType","academicyear_id","subject_id","isaccepted"}))
public class QuestionPaper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String campus;
 @ManyToOne(fetch=FetchType.LAZY)
 @JsonIgnore
  private Academicyear academicyear;
 @ManyToOne
 private Subject subject;
    @Column(nullable = false)
    @JsonIgnore
    private String examType;

    private String fileUrl;
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="uploaded_id")
//    @JsonIgnore
//    private User uploadedBy;
@Column(name = "uploaded_id")
private Long uploadedBy;

    @Transient
    private UserDTO uploadedByUser; // Used for response only


    private boolean isaccepted;

    public Academicyear getAcademicyear() {
        return academicyear;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public void setAcademicyear(Academicyear academicyear) {
        this.academicyear = academicyear;
    }
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public boolean isIsaccepted() {
        return isaccepted;
    }

    public void setIsaccepted(boolean isaccepted) {
        this.isaccepted = isaccepted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Long getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedByUserId(Long uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public UserDTO getUploadedByUser() {
        return uploadedByUser;
    }

    public void setUploadedByUser(UserDTO uploadedByUser) {
        this.uploadedByUser = uploadedByUser;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }


}
