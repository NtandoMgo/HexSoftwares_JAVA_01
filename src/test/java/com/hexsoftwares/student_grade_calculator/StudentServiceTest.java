package com.hexsoftwares.student_grade_calculator;

import com.hexsoftwares.student_grade_calculator.model.Student;
import com.hexsoftwares.student_grade_calculator.service.StudentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @BeforeEach
public void setup() {
    
    // Add test students
    studentService.saveStudent(new Student("Ntandoyabalele Mngomezulu", "MNGNTA011", 85.5, "Passed"));
        studentService.saveStudent(new Student("Thabo Mbeki", "MBETHA001", 75.0, "Passed"));
        studentService.saveStudent(new Student("Nelson Mandela", "MANNEL002", 95.0, "Passed"));
        studentService.saveStudent(new Student("Wangari Maathai", "MAAWAN003", 85.5, "Passed"));
        studentService.saveStudent(new Student("Chimamanda Ngozi Adichie", "ADICHI004", 88.0, "Passed"));
        studentService.saveStudent(new Student("Nomsa Ntladi", "NTLNOM056", 82.0, "Passed"));
    studentService.saveStudent(new Student("Uche Nwankwo", "NWAUC057", 80.0, "Passed"));
    studentService.saveStudent(new Student("Tinashe J. Chigumbura", "CHITIN058", 75.0, "Passed"));
    studentService.saveStudent(new Student("Thandeka Zulu", "ZULTHA059", 70.0, "Passed"));
    studentService.saveStudent(new Student("Mandla Maphumulo", "MAPMAN060", 69.0, "Failed"));
    studentService.saveStudent(new Student("Lindiwe Dlamini", "DLAIND061", 91.0, "Passed"));
    studentService.saveStudent(new Student("Tshepo Motsepe", "MOTTSH062", 82.0, "Passed"));
    studentService.saveStudent(new Student("Kamala Harris", "HARISM063", 95.0, "Passed"));
    studentService.saveStudent(new Student("Freddie Mercury", "MERFRE064", 89.0, "Passed"));
    studentService.saveStudent(new Student("Amos M. Chigumira", "CHIAMO065", 88.0, "Passed"));

    // Update grades and status for some students
    studentService.updateStudentGradeStatus("NTLNOM056", 45.0, "Failed"); // Nomsa Ntladi
    studentService.updateStudentGradeStatus("NWAUC057", 48.0, "Failed"); // Uche Nwankwo
    studentService.updateStudentGradeStatus("CHITIN058", 49.0, "Failed"); // Tinashe J. Chigumbura
    studentService.updateStudentGradeStatus("ZULTHA059", 45.0, "Failed"); // Thandeka Zulu
}

    @Test
public void testGetAllStudents() {
    List<Student> students = studentService.getAllStudents();
    
    // Print results to console to see what's being retrieved
    students.forEach(student -> 
        System.out.println("ID: " + student.getId() + 
                           ", Name: " + student.getName() + 
                           ", Average: " + student.getAverage() + 
                           ", Status: " + student.getStatus())
    );

    // Check if the expected number of students is retrieved
    assertThat(students.size()).isGreaterThan(0);
}
}