package com.example.loginspring.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/home")
    public String showHome(){
        return "homepage";
    }
}
