package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Example2.class);
        Example2 e1 = context.getBean(Example2.class);
        Example2 e2 = context.getBean(Example2.class);

        System.out.println(e1==e2);
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
    }
}
