//package com.example.demo.Entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class Department {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private DepartmentName department_name;
//
//
//    public DepartmentName getDepartment_name() {
//        return department_name;
//    }
//
//    public void setDepartment_name(DepartmentName department_name) {
//        this.department_name = department_name;
//    }
//
//
//    public enum DepartmentName {
//        CSE, ECE, EEE, MECH, CHEMICAL, CIVIL, METALLURGY
//    }
//}
package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) // Store as a String in the DB
    private DepartmentName departmentName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DepartmentName getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(DepartmentName departmentName) {
        this.departmentName = departmentName;
    }

    public enum DepartmentName {
        CSE, ECE, EEE, MECH, CHEMICAL, CIVIL, METALLURGY
    }
}
