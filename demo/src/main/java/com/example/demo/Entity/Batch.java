////package com.example.demo.Entity;
////import jakarta.persistence.Entity;
////import jakarta.persistence.GeneratedValue;
////import jakarta.persistence.GenerationType;
////import jakarta.persistence.Id;
////@Entity
////public class Batch {
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    public Long getId() {
////        return id;
////    }
////
////    public void setId(Long id) {
////        this.id = id;
////    }
////}
//package com.example.demo.Entity;
//
//import jakarta.persistence.*;
//
//@Entity
//public class Batch {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "academic_year_id", nullable = false) // This acts as a foreign key
//    private Academicyear academicYear;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Academicyear getAcademicYear() {
//        return academicYear;
//    }
//
//    public void setAcademicYear(Academicyear academicYear) {
//        this.academicYear = academicYear;
//    }
//}
package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "academic_year_id", nullable = false) // Foreign key for Academic Year
    private Academicyear academicYear;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false) // Foreign key for Department
    private Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
