package com.marin.coronavirusapp.controller;

import com.marin.coronavirusapp.model.CoronavirusData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoronavirusController {

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("coronavirusData", CoronavirusData.virusData);

        return "home";
    }

}
