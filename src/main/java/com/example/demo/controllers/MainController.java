package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/main")
    public String get_index(Model model) {
        model.addAttribute("tmp", "Привет спринг");
        return "info";
    }

    @PostMapping("/main")
    public String post_index(
            @RequestParam(name = "star", required = false, defaultValue = "0") Integer name_star) {
        return "info";
    }

    @GetMapping("/")
    public String calculator() {
        return "calculator";
    }

    @GetMapping("/calculator")
    public String get_calculator(
            @RequestParam(name = "numone") double name_numone,
            @RequestParam(name = "numtwo") double name_numtwo,
            @RequestParam(name = "operator") String name_operator,
            Model model
    ) {
        double res = switch (name_operator) {
            case "+" -> name_numone + name_numtwo;
            case "-" -> name_numone - name_numtwo;
            case "*" -> name_numone * name_numtwo;
            case "/" -> name_numone / name_numtwo;
            default -> 0;
        };
        model.addAttribute("res", res);
        return "calculator";
    }

    @PostMapping("/calculator")
    public String post_calculator(
            @RequestParam(name = "numone", required = false, defaultValue = "0") double name_numone,
            @RequestParam(name = "numtwo", required = false, defaultValue = "0") double name_numtwo,
            @RequestParam(name = "operator", required = false, defaultValue = "0") String name_operator,
            Model model
    ) {
        double res = switch (name_operator) {
            case "+" -> name_numone + name_numtwo;
            case "-" -> name_numone - name_numtwo;
            case "*" -> name_numone * name_numtwo;
            case "/" -> name_numone / name_numtwo;
            default -> 0;
        };
        model.addAttribute("res", res);
        return "calculator";
    }
}
