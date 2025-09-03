package com.crowdsolve.crowdsolve_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthViewController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";  // maps to src/main/resources/templates/login.html
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";  // maps to src/main/resources/templates/signup.html
    }
}