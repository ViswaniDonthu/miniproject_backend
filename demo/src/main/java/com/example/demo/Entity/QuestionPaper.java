//package com.example.demo.Entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class QuestionPaper {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private long id;
//    private  String file_url;
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getFile_url() {
//        return file_url;
//    }
//
//    public void setFile_url(String file_url) {
//        this.file_url = file_url;
//    }
//}
package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class QuestionPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String file_url;

    @ManyToOne
    @JoinColumn(name = "academic_year_id", nullable = false) // Foreign key for AcademicYear
    private Academicyear academicYear;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false) // Foreign key for Department
    private Department department;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false) // Foreign key for Subjects
    private Subjects subject;

    @ManyToOne
    @JoinColumn(name = "uploaded_by", nullable = false) // Foreign key for User (Uploader)
    private User uploadedBy;

    @ManyToOne
    @JoinColumn(name = "exam_type_id", nullable = false) // Foreign key for ExamTypes
    private ExamTypes examType;

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public Academicyear getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(Academicyear academicYear) {
        this.academicYear = academicYear;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public User getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(User uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public ExamTypes getExamType() {
        return examType;
    }

    public void setExamType(ExamTypes examType) {
        this.examType = examType;
    }
}
