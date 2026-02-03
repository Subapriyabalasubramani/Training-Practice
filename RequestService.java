package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class RequestService {

    private final RequestDemo requestDemo;

    public RequestService(RequestDemo requestDemo){
        this.requestDemo = requestDemo;
    }

    public String getRequestIdFromService(){
        return "requestId: " + requestDemo.getRequestId();
    }
}
