package com.example.NetworksEnergyTestProject.controllers;

import com.example.NetworksEnergyTestProject.models.User;
import com.example.NetworksEnergyTestProject.services.RegistrationService;
import com.example.NetworksEnergyTestProject.util.PersonValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final PersonValidator personValidator;
    private final RegistrationService registrationService;

    @Autowired
    public AuthController(PersonValidator personValidator, RegistrationService registrationService) {
        this.personValidator = personValidator;
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") User user) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid User user, BindingResult bindingResult) {
        personValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors())
            return "/auth/registration";

        registrationService.register(user);

        return "redirect:/auth/login";
    }

}
