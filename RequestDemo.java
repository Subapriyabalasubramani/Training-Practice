package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

@Component
@RequestScope
public class RequestDemo {

    private final String requestId = UUID.randomUUID().toString();

    public String getRequestId(){
        return requestId;
    }
}
