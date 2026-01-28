package com.telusco.joblisting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(
            Model model
    ) {

        Employee e = new Employee(
                "Adam",
                    "Savage",
                "adam@12proton.me",
                "8854312345"
        );
        model.addAttribute("employee", e);

        return "index";
    }
}

class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    public Employee(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}
