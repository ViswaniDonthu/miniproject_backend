package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class ExamTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ExamType exam_name;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExamType getExam_name() {
        return exam_name;
    }

    public void setExam_name(ExamType exam_name) {
        this.exam_name = exam_name;
    }
    public enum ExamType {
        MID_1, MID_2, MID_3, AT_1, AT_2, AT_3, AT_4, SEMESTER, SUPPLY
    }
}
