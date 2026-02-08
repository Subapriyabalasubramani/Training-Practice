package org.example.controller;

import org.example.dto.DeptDTO;
import org.example.entity.Department;
import org.example.service.DeptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    private DeptService deptService;

    public DeptController(DeptService deptService){
        this.deptService = deptService;
    }

    @PostMapping("/create")
    public Department createDepartment(@RequestBody DeptDTO dept){
        return deptService.createDept(dept.getDeptName(), dept.getEmployee().getName(), dept.getEmployee().getEmail());
    }

    @GetMapping("/dept")
    public List<Department> getAllDepartment(){
        return deptService.getAllDept();
    }

    @GetMapping("/dept/{id}")
    public Department getDepartmentById(@PathVariable Integer id){
        return deptService.getDeptById(id);
    }

    @DeleteMapping("/dept/{id}")
    public String deleteDepartmentById(@PathVariable Integer id){
        deptService.deleteDeptById(id);
        return "Deleted department with id: "+id;
    }
}
