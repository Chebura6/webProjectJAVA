package org.pancakes.controller;


import org.pancakes.entities.Bakery;
import org.pancakes.entities.User;
import org.pancakes.entities.UserDto;
import org.pancakes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class SecurityController {

    @Autowired
    public UserService userService;

    @GetMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findByUsername(userDto.getUsername());

        if(existingUser != null){
            result.rejectValue("username", null,
                    "There is already an account registered with the same name");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.save(userDto);
        return "redirect:/register?success";
    }


}
