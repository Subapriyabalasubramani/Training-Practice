package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController
{
    private final SessionDemo sessionDemo;

    public SessionController(SessionDemo sessionDemo){
        this.sessionDemo = sessionDemo;
    }

    @GetMapping("/test/session-id")
    public String getIdFromController(){
        return sessionDemo.getSessionId();
    }
}
