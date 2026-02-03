package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    private final ApplicationDemo applicationDemo;

    public ApplicationController(ApplicationDemo applicationDemo){
        this.applicationDemo = applicationDemo;
    }

    @GetMapping("/test/app-id")
    public String getIdFromController(){
        return applicationDemo.getApplicationId();
    }
}
