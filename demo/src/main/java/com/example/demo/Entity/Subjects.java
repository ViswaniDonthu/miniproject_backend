//package com.example.demo.Entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class Subjects {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private long id;
//    private String subject_name;
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getSubject_name() {
//        return subject_name;
//    }
//
//    public void setSubject_name(String subject_name) {
//        this.subject_name = subject_name;
//    }
//}
package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String subject_name;

    @ManyToOne
    @JoinColumn(name = "semester_id", nullable = false) // Foreign key for Semester
    private Semester semester;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
