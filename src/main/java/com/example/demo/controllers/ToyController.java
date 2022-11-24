package com.example.demo.controllers;

import com.example.demo.models.Toy;
import com.example.demo.repositories.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/detail/{id}")
    public String detailtoy(
            @PathVariable Long id,
            Model model
    ) {
        Toy toy_obj = toyRepository.findById(id).orElseThrow();
        model.addAttribute("one_toy", toy_obj);

        return "toy/info";
    }

    @GetMapping("/detail/{id}/del")
    public String delToy(@PathVariable Long id,
                            Model model) {
        Toy toy_obj = toyRepository.findById(id).orElseThrow();
        toyRepository.delete(toy_obj);

        return "redirect:/toy/";
    }

    @GetMapping("/detail/{id}/upd")
    public String updateView(
            @PathVariable Long id,
            Model model
    ) {
        model.addAttribute("object",
                toyRepository.findById(id).orElseThrow());
        return "toy/update";
    }

    @PostMapping("/detail/{id}/upd")
    public String updateView(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String type,
            @RequestParam String form,
            @RequestParam Integer height,
            @RequestParam Double cost
    ) {
        Toy toy = toyRepository.findById(id).orElseThrow();

        toy.setName(name);
        toy.setType(type);
        toy.setForm(form);
        toy.setHeight(height);
        toy.setCost(cost);


        toyRepository.save(toy);

        return "redirect:/toy/detail/" + toy.getId();
    }

    @GetMapping("/filter")
    public String filter(@RequestParam(name = "name") String name,
                         Model model) {
        List<Toy> toyList = toyRepository.findByName(name);
        model.addAttribute("toy_list", toyList);

        return "toy/index";
    }
}
