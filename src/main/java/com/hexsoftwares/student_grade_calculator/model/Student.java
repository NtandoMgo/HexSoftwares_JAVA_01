package com.hexsoftwares.student_grade_calculator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ElementCollection;
import javax.persistence.Table;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "student_id", nullable = false, unique = true)
    private String studentId;

    @ElementCollection
    private List<Double> grades = new ArrayList<>();

    private double average;
    private String status;

    public Student() {}

    public Student(String name, String studentId, List<Double> grades) {
        this.name = name;
        this.studentId = studentId;
        this.grades = grades != null ? grades : new ArrayList<>();
        calculateAverage();
        determineStatus();
    }

    // Calculate average grade
    public void calculateAverage() {
        if (!grades.isEmpty()) {
            this.average = grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        } else {
            this.average = 0.0;  // Default value if no grades
        }
    }

    // Determine if the student passed or failed
    public void determineStatus() {
        this.status = this.average >= 50 ? "Passed" : "Failed";
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
        calculateAverage(); // Recalculate average after setting new grades
        determineStatus();  // Recalculate status
    }

    public double getAverage() {
        return average;
    }

    public String getStatus() {
        return status;
    }
}
