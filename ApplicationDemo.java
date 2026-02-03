package com.example.demo;


import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.UUID;

@Service
@ApplicationScope
public class ApplicationDemo {

    private final String id;

    public ApplicationDemo(){
        this.id = UUID.randomUUID().toString();
        System.out.println("AppBean Created (Only once for whole app): " + id);
    }

    public String getApplicationId(){
        return id;
    }
}
