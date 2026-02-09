package org.example.controller;

import org.example.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/by-email")
    public Employee findEmployeeByEmail(@RequestParam String email){
        return employeeService.findEmpByEmail(email);
    }

    @GetMapping("/by-salary-greater")
    public List<Employee> findEmployeeBySalaryGreater(@RequestParam double salary){
        return employeeService.findEmpBySalaryGreater(salary);
    }

    @GetMapping("/by-name")
    public Employee findEmployeeByName(@RequestParam String name){
        return employeeService.findEmpByName(name);
    }

    @GetMapping("/emp_sal")
    public Employee findEmployeeBySalary(@RequestParam double salary){
        return employeeService.findEmpBySal(salary);
    }

    @GetMapping("/highest-salary")
    public double findHighestSalary(){
        return employeeService.findHighestSal();
    }

    @GetMapping("/emp")
    public List<Employee> getEmployeeSalary(@RequestParam double salary){
        return employeeService.getEmployee(salary);
    }
}


