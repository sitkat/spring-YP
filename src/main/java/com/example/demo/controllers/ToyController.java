package com.example.demo.controllers;

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
@RequestMapping("/toy")
public class ToyController {
    @Autowired
    ToyRepository toyRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Toy> toyIterable = toyRepository.findAll();
        model.addAttribute("toy_list", toyIterable);

        return "toy/index";
    }

    @GetMapping("/add")
    public String addView() { return "toy/add-toy"; }

    @PostMapping("/add")
    public String AddToy(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "type") String type,
            @RequestParam(name = "form") String form,
            @RequestParam(name = "height") int height,
            @RequestParam(name = "cost") double cost
    ){
        Toy new_toy = new Toy(name, type, form, height, cost);
        toyRepository.save(new_toy);
        return "redirect:/toy/";
    }
}
