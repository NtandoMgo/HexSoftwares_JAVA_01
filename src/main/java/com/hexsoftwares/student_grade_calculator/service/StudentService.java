package com.hexsoftwares.student_grade_calculator.service;

import com.hexsoftwares.student_grade_calculator.model.Student;
import com.hexsoftwares.student_grade_calculator.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public int getTotalNumberOfStudents() {
        return (int) studentRepository.count();
    }

    public List<Student> getTopStudents(int limit) {
        return studentRepository.findAll().stream()
                .sorted((s1, s2) -> Double.compare(s2.getAverage(), s1.getAverage()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public double calculateClassAverage() {
        List<Student> students = getAllStudents();
        if (students.isEmpty()) {
            return 0.0;
        }
        return students.stream()
                .mapToDouble(Student::getAverage)
                .average()
                .orElse(0.0);
    }

    public void updateStudentGradeStatus(String studentId, double newGrade, String newStatus) {
        Student student = studentRepository.findByStudentId(studentId);
        if (student != null) {
            student.setAverage(newGrade);
            student.setStatus(newStatus);
            studentRepository.save(student);
        }
    }
}
