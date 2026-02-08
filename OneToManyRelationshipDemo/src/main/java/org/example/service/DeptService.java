package org.example.service;

import org.example.entity.Department;
import org.example.entity.Employee;
import org.example.repo.DeptRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    private DeptRepo deptRepo;

    public DeptService(DeptRepo deptRepo){
        this.deptRepo = deptRepo;
    }

    public Department createDept(String deptName, String name, String email){
        Department dept = new Department(deptName);
        Employee emp = new Employee(name, email);

        dept.addEmployee(emp);
        return deptRepo.save(dept);
    };

    public List<Department> getAllDept(){
        return deptRepo.findAll();
    }

    public Department getDeptById(Integer id){
        return deptRepo.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public void deleteDeptById(Integer id){
        deptRepo.deleteById(id);
    }
}
