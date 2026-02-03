package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class DestructionDemo {

    public DestructionDemo(){
        System.out.println("1. Constructor called");
    }

    @PostConstruct
    public void init(){
        System.out.println("2. this method is being called after the bean initialized");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("3. this method is called before the bean is being destroyed");
    }
}
