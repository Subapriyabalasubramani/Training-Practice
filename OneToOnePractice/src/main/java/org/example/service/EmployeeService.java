package org.example.service;

import jakarta.transaction.Transactional;
import org.example.entity.Employee;
import org.example.entity.EmployeeProfile;
import org.example.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee createEmp(String name, String email, String phone, String address) {
        Employee employee = new Employee(name, email);
        EmployeeProfile empProfile = new EmployeeProfile(phone, address);

        employee.setEmployeeProfile(empProfile);
        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmp() {
        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmpById(Integer id) {
        return employeeRepo.findById(id);
    }

    public void deleteEmpById(Integer id) {
        employeeRepo.deleteById(id);
    }

    @Transactional
    public Employee updateEmp(Integer id, String name, String email, String phone, String address) {
        Employee emp = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        emp.setName(name);
        emp.setEmail(email);
        EmployeeProfile empProfile = emp.getEmployeeProfile();
        if (empProfile == null) {
            empProfile = new EmployeeProfile();
            emp.setEmployeeProfile(empProfile);
        }
        empProfile.setPhone(phone);
        empProfile.setAddress(address);

        return employeeRepo.save(emp);
    }
}
