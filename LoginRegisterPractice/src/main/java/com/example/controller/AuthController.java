package com.example.controller;

import com.example.model.LoginForm;
import com.example.model.RegisterForm;
import com.example.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String showRegister(Model model){
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("registerForm") RegisterForm form,
                               BindingResult result,
                               Model model){
        if(result.hasErrors()){
            return "register";
        }

        if(userService.exists(form.getEmail())){
            model.addAttribute("error","Email already registered. Please login");
            return "register";
        }
        userService.register(form.getName(), form.getEmail(), form.getPassword());
        return "redirect:/login?registered=true";
    }

    @GetMapping("/login")
    public String showLogin(@RequestParam(required = false) String registered, Model model){   // here giving required false, will not give error when a user logins with /login
        model.addAttribute("loginForm", new LoginForm());

        if(("true").equals(registered)){
            model.addAttribute("msg", "Registration Successful. Please login");
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute("loginForm") LoginForm form,
                            BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            return "login";
        }

        boolean userLoginCheck = userService.validateLogin(form.getEmail(), form.getPassword());

        if(!userLoginCheck){
            model.addAttribute("error", "Invalid email or Password");
            return "login";
        }
        session.setAttribute("userEmail", form.getEmail());
        return "redirect:/dashboard";
    }

    @GetMapping("/logout")
    public String logoutUser(HttpSession session){
        session.invalidate();
        return "redirect:/login?logout=true";
    }

}
