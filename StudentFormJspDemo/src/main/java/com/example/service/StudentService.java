package com.example.service;

import com.example.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> studentsList = new ArrayList<>();

    public void addStudent(Student student){
        studentsList.add(student);
    }

    public List<Student> getAllStudent(){
        return studentsList;
    }

    public void deleteStudentByEmail(String email){
        studentsList.removeIf(student -> student.getEmail().equalsIgnoreCase(email));
    }
}
