package com.example.NetworksEnergyTestProject.util;

import com.example.NetworksEnergyTestProject.models.User;
import com.example.NetworksEnergyTestProject.services.PersonDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PersonDetailService personDetailService;

    @Autowired
    public PersonValidator(PersonDetailService personDetailService) {
        this.personDetailService = personDetailService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        try {
            personDetailService.loadUserByUsername(user.getUsername());
        } catch (UsernameNotFoundException e) {
            return;
        }

        errors.rejectValue("username", "", "User exist");
    }
}
