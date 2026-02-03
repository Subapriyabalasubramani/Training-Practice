package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

@Service
@SessionScope
public class SessionDemo {
    private final String sessionId;

    public SessionDemo() {
        this.sessionId = UUID.randomUUID().toString();
        System.out.println("SessionBean Created: " + sessionId);
    }

    public String getSessionId() {
        return sessionId;
    }
}
