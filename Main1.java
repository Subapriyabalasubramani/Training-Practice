package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Example1.class);
        Example1 e1 = context.getBean(Example1.class);
        Example1 e2 = context.getBean(Example1.class);

        System.out.println(e1==e2);
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
    }
}
