package org.example.repo;

import org.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findByEmail(String email);

    List<Employee> findBySalaryGreaterThan(double salary);

    @Query(value = "Select e from Employee e where e.name = :name")
    Employee getEmpByName(@Param("name") String name);

    @Query(value = "Select e from Employee e where e.salary = ?1")
    Employee getEmpBySalary(double salary);

    @Query(value = "Select Max(salary) from emp_table", nativeQuery = true)
    double getHighestSal();

    @Query(value = "Select * from emp_table where name like 'A%' and salary > :salary", nativeQuery = true)
    List<Employee> getEmpBySalAndName(@Param("salary") double salary);
}
