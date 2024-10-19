package com.hexsoftwares.student_grade_calculator.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String studentId;

    @ElementCollection
    private List<Double> grades;

    private double average;
    private String status;

    // Default constructor
    public Student () {}

    public Student(String name, String studentId, double d, String stat) {
        this.name = name;
        this.studentId = studentId;
        average = d;
        status = stat;
    }

    public Student(String name, String studentId, List<Double> grades) {
        this.name = name;
        this.studentId = studentId;
        setGrades(grades); // Use setter to calculate average and status
    }

    public void calculateAverage() {
        // Check if grades is null or empty
        if (grades == null || grades.isEmpty()) {
            this.average = 0.0;  // Assign a default value
            this.status = "No grades available";  // Update status accordingly
        } else {
            // Calculate the average of the grades
            this.average = grades.stream()
                .filter(grade -> grade >= 0 && grade <= 100) // Ensure grades are within a valid range
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0); // Default to 0.0 if no valid grades exist
            
            // Update status based on the average
            determineStatus();
        }
    }

    public void determineStatus() {
        this.status = this.average >= 50 ? "Passed" : "Failed"; // Make threshold configurable if needed
    }

    public String displayGrades() {
        return grades != null ? grades.toString() : "No grades available";
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                ", grades=" + grades +
                ", average=" + average +
                ", status='" + status + '\'' +
                '}';
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
        calculateAverage();
        determineStatus();
    }

    public double getAverage() {
        return average;
    }

    public String getStatus() {
        return status;
    }

    public void setAverage(double newGrade) {
        average = newGrade;
    }

    public void setStatus(String newStatus) {
        status = newStatus;
    }
}
