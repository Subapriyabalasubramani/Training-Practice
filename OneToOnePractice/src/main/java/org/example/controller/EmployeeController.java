package org.example.controller;

import org.example.dto.EmployeeRequest;
import org.example.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService empService;

    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return empService.createEmp(employeeRequest.getName(), employeeRequest.getEmail(), employeeRequest.getProfileRequest().getPhone(), employeeRequest.getProfileRequest().getAddress());
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return empService.getAllEmp();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Integer id) {
        return empService.getEmpById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployeeById(@PathVariable Integer id, @RequestBody EmployeeRequest employeeRequest) {
        return empService.updateEmp(id, employeeRequest.getName(), employeeRequest.getEmail(), employeeRequest.getProfileRequest().getPhone(), employeeRequest.getProfileRequest().getAddress());
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable Integer id) {
        empService.deleteEmpById(id);
        return "Employee deleted with id: " + id;
    }
}
