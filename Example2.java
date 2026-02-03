package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Example2 {
    public Example2(){
        System.out.println("Bean created everytime using the getBean method - prototype scope");
    }
}
