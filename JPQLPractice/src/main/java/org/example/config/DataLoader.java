package org.example.config;

import org.example.entity.Employee;
import org.example.repo.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadRunner(EmployeeRepository repo){
        return args -> {
            repo.save(new Employee("John", "john@gmail.com", 50000, "Bangalore"));
            repo.save(new Employee("Alice", "alice@gmail.com", 65000, "Chennai"));
            repo.save(new Employee("Bob", "bob@gmail.com", 45000, "Trichy"));
            repo.save(new Employee("David", "david@gmail.com", 70000, "Hyderbad"));
            repo.save(new Employee("Emma", "emma@gmail.com", 55000, "Chennai"));
        };
    }
}
