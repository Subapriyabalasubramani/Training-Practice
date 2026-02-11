package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/html-page")
    @ResponseBody
    public String getHomePage(){
        return """
                <html>
                <body>
                 <h1>Welcome to Jsp demo</h1>
                 <p>This is an example how the controller returns the response as html page.</p>
                </body>
                </html>
                """;
    }

    @GetMapping("/jsp-demo")
    public String getHomeJsp(Model model){
        model.addAttribute("name", "suba");
        model.addAttribute("age", "22" );
        model.addAttribute("city", "erode");

        return "home";
    }
}
