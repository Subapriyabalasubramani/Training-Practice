package com.example.controller;

import com.example.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.crypto.interfaces.DHKey;

@Controller
public class DashboardController {

    private UserService service;

    public DashboardController(UserService service){
        this.service = service;
    }

    @GetMapping("/dashboard")
    public String userDashboard(HttpSession session, Model model){
        String email = (String) session.getAttribute("userEmail");

        if(email == null){
            return "redirect:/login";
        }
        model.addAttribute("name", service.getUserName(email));
        model.addAttribute("email",email);

        return "dashboard";
    }
}
