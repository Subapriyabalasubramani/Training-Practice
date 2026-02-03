package com.example.springjdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO {

    /*private final JdbcTemplate jdbcTemplate;

    public EmployeeDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> findAllEmployees(){
        String sql = "SELECT * FROM EMPLOYEE";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    public int setEmployeeInfo(Employee employee){
        String sql = "INSERT INTO EMPLOYEE (ID, NAME, SALARY) VALUES(?,?,?)";
        return jdbcTemplate.update(
                sql,
                employee.getId(),
                employee.getName(),
                employee.getSalary()
        );
    }*/

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public EmployeeDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    //insert

    public int setEmployeeInfo (Employee employee){

        String sql = """
                INSERT INTO EMPLOYEE (ID, NAME, SALARY)
                VALUES (:id, :name, :salary)
                """;
        SqlParameterSource params =
                new BeanPropertySqlParameterSource(employee);    //auto-binding

        return namedParameterJdbcTemplate.update(sql, params);
    };

    public Employee getEmployeeById(int id){

        //named parameter :id
        String sql = """
                SELECT * FROM EMPLOYEE WHERE ID = :id   
                """;
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id" , id );     //binding id parameter with the id from the url path
        return namedParameterJdbcTemplate.queryForObject(sql, params, new EmployeeRowMapper());
    }

}
