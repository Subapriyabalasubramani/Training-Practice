package com.example.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String, String> users = new HashMap<>();
    private Map<String, String> names = new HashMap<>();

    public void register(String name, String email, String password){
        users.put(email, password);
        names.put(email, name);
    }

    public boolean exists(String email){
         return users.containsKey(email);
    }

    public boolean validateLogin(String email, String password){
        return users.containsKey(email) && users.get(email).equalsIgnoreCase(password);
    }

    public String getUserName(String email){
        return names.get(email);
    }
}
