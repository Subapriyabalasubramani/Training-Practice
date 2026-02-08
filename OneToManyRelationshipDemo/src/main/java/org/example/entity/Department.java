package org.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dept")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
    @SequenceGenerator(name = "dept_seq", sequenceName = "dept_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String deptName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Employee> employeeList = new ArrayList<>();

    public Department(){}

    public Department(String deptName){
        this.deptName = deptName;
    }

    public void addEmployee(Employee emp){
        employeeList.add(emp);
        emp.setDepartment(this);
    }

    public void removeEmployee(Employee emp){
        employeeList.remove(emp);
        emp.setDepartment(null);
    }

    public Integer getId(){
        return id;
    }

    public String getDeptName(){
        return deptName;
    }

    public void setDeptName(String deptName){
        this.deptName = deptName;
    }

    public List<Employee> getEmployeeList(){
        return employeeList;
    }
}
