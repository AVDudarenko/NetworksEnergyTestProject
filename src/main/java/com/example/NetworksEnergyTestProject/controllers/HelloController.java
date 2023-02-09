package com.example.NetworksEnergyTestProject.controllers;

import com.example.NetworksEnergyTestProject.security.PersonDetails;
import com.example.NetworksEnergyTestProject.services.PersonDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController {

    private final PersonDetailService personDetailService;

    @Autowired
    public HelloController(PersonDetailService personDetailService) {
        this.personDetailService = personDetailService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getUser());

        return "hello";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

}
