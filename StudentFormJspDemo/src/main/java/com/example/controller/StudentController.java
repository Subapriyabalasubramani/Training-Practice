package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/new")
    public String showForm(Model model){
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/save")
    public String saveForm(@Valid @ModelAttribute("student") Student student,
                           BindingResult result,
                           Model model){
        if(result.hasErrors()){
            return "student-form";
        }

        studentService.addStudent(student);
        model.addAttribute("msg", "Student data added successfully");
        return "success";
    }

    @GetMapping
    public String getAllStudentsList(Model model){
        model.addAttribute("studentsList", studentService.getAllStudent());   // when we give addAttribute, internally spring will setAttribute to the request scope. so that the data will exist
        return "students-list";
    }

    @GetMapping("/delete")
    public String deleteStudentByEmail(@RequestParam String email){
        studentService.deleteStudentByEmail(email);
        return "redirect:/students";
    }
}
