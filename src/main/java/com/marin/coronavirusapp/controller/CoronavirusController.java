package com.marin.coronavirusapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoronavirusController {

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("test", "TEST");

        return "home";
    }

}
