package com.example.loginspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LoginSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginSpringApplication.class, args);
    }
    @GetMapping("/users")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "Word") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/admin")
    public String sayAdmin(@RequestParam(value = "myName", defaultValue = "Wordd") String name) {
        return String.format("Admin Hello %s", name);
    }
}














