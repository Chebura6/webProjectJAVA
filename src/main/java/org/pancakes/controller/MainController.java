package org.pancakes.controller;


import org.pancakes.entities.*;
import org.pancakes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    public long totalTime;
    @Autowired
    public UserService userService;

    @GetMapping("/pancake")
    public String index(Model model) {

        return "pancake";
    }

    @GetMapping("/")
    public String index_(Model model) {

        return "pancake";
    }


    @GetMapping("cookie")
    public String cookie() {
        return "cookie";
    }

    @GetMapping("bakery")
    public String bakery() {
        return "bakery";
    }

    @GetMapping("assortment")
    public String assortment() {
        return "assortment";
    }
    @GetMapping("createBakery")
    public String createBakery(ProductDTO productDTO) {
        return "createBakery";
    }
    @GetMapping("createPancake")
    public String createPancake(ProductDTO productDTO) { return "createPancake";}
    @GetMapping("createCookie")
    public String createCookie(ProductDTO productDTO) { return "createCookie";}
}
