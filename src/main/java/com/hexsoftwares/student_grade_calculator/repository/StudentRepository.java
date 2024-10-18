package com.hexsoftwares.student_grade_calculator.repository;

import com.hexsoftwares.student_grade_calculator.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
