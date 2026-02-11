package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("/sample")
    public String getSample(Model model){
        model.addAttribute("name", "suba");
        model.addAttribute("email","subapriya@gmail.com");
        return "sample";
    }
}
