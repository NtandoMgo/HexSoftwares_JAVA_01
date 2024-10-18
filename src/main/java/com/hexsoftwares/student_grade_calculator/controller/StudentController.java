package com.hexsoftwares.student_grade_calculator.controller;

import com.hexsoftwares.student_grade_calculator.model.Student;
import com.hexsoftwares.student_grade_calculator.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping("/add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/class-average")
    public String classAverage(Model model) {
        double average = studentService.calculateClassAverage();
        model.addAttribute("average", average);
        return "class-average"; 
    }

    // @GetMapping("/edit/{id}")
    // public String editStudentForm(@PathVariable Long id, Model model) {
    //     Student student = studentService.getStudentById(id);
    //     model.addAttribute("student", student);
    //     return "add-student";
    // }

    // @PostMapping("/edit/{id}")
    // public String editStudent(@PathVariable Long id, @ModelAttribute Student student) {
    //     student.setId(id);
    //     studentService.saveStudent(student);
    //     return "redirect:/students";
    // }

    // @GetMapping("/delete/{id}")
    // public String deleteStudent(@PathVariable Long id) {
    //     studentService.deleteStudent(id);
    //     return "redirect:/students";
    // }
}
