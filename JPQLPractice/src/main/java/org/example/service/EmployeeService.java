package org.example.service;

import org.example.entity.Employee;
import org.example.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee findEmpByEmail(String email){
        return employeeRepository.findByEmail(email);
    }

    public List<Employee> findEmpBySalaryGreater(double sal){
        return employeeRepository.findBySalaryGreaterThan(sal);
    }

    public Employee findEmpByName(String name){
        return employeeRepository.getEmpByName(name);
    }

    public Employee findEmpBySal(double salary){
        return employeeRepository.getEmpBySalary(salary);
    }

    public double findHighestSal(){
        return employeeRepository.getHighestSal();
    }

    public List<Employee> getEmployee(double salary){
        return employeeRepository.getEmpBySalAndName(salary);
    }

}
