//package com.example.demo.Entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//
//@Entity
//public class Semester {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Enumerated(EnumType.STRING)
//    private SemesterNo semester_no;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public SemesterNo getSemester_no() {
//        return semester_no;
//    }
//
//    public void setSemester_no(SemesterNo semester_no) {
//        this.semester_no = semester_no;
//    }
//
//    public enum SemesterNo {
//        SEM1, SEM2
//    }
//}
package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SemesterNo semesterNo;

    @ManyToOne
    @JoinColumn(name = "batch_id", nullable = false) // Foreign key for Batch
    private Batch batch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SemesterNo getSemesterNo() {
        return semesterNo;
    }

    public void setSemesterNo(SemesterNo semesterNo) {
        this.semesterNo = semesterNo;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public enum SemesterNo {
        SEM1, SEM2
    }
}
