package com.example.demo.controllers;

import com.example.demo.models.Flower;
import com.example.demo.models.Toy;
import com.example.demo.repositories.FlowerRepository;
import com.example.demo.repositories.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/flower")
public class FlowerController {
    @Autowired
    FlowerRepository flowerRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Flower> flowerIterable = flowerRepository.findAll();
        model.addAttribute("flower_list", flowerIterable);

        return "flower/index";
    }

    @GetMapping("/add")
    public String addView() { return "flower/add-flower"; }

    @PostMapping("/add")
    public String AddFlower(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "type") String type,
            @RequestParam(name = "color") String color,
            @RequestParam(name = "smell") String smell,
            @RequestParam(name = "cost") double cost
    ){
        Flower new_flower = new Flower(name, type, color, smell, cost);
        flowerRepository.save(new_flower);
        return "redirect:/flower/";
    }
}
