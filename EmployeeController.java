package com.example.springjdbc;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

//    @GetMapping("/employees")
//    public List<Employee> getAllEmps(){
//        return employeeDAO.findAllEmployees();
//    }
//
//    @PostMapping("/employee-info")
//    public String setEmployee(@RequestBody Employee employee){
//        employeeDAO.setEmployeeInfo(employee);
//        return "Record added successfully";
//    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id){     //binds id from url path to parameter
        return employeeDAO.getEmployeeById(id);
    }

    @PostMapping("/employee-info")
    public String setEmployee(@RequestBody Employee employee){
        employeeDAO.setEmployeeInfo(employee);
        return "Record added successfully in the db";
    }
}
