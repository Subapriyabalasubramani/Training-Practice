package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueAnnotation {
    @Value("${app.name}")
    private String name;

    @Value("${server.port}")
    private int port;

    @Value("${app.owner}")
    private String owner;

    @PostConstruct
    public void propertiesDetails(){
        System.out.println("This is called after the bean initialized");
        System.out.println(name + " " + port + " " + owner);
    }
}
