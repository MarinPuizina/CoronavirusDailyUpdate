package com.marin.coronavirusapp.controller;

import com.marin.coronavirusapp.model.CoronavirusData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoronavirusController {

    @GetMapping("/")
    public String home(Model model) {

        int totalNumberOfCases = CoronavirusData.virusData
                .stream()
                .mapToInt(data -> data.getNumberOfCases())
                .sum();

        int totalNumberOfNewCases = CoronavirusData.virusData
                .stream()
                .mapToInt(data -> data.getNewCases())
                .sum();

        model.addAttribute("coronavirusData", CoronavirusData.virusData);
        model.addAttribute("totalNumberOfCases", "INFECTED: " + totalNumberOfCases);
        model.addAttribute("totalNumberOfNewCases", "NEW CASES: " + totalNumberOfNewCases);

        return "home";
    }

}
