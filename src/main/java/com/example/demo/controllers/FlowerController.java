package com.example.demo.controllers;

import com.example.demo.models.Flower;
import com.example.demo.repositories.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @PreAuthorize("hasAnyAuthority('FLORIST','ADMIN')")
    @GetMapping("/add")
    public String addView(Flower flower) {
        return "flower/add-flower";
    }

    @PreAuthorize("hasAnyAuthority('FLORIST','ADMIN')")
    @PostMapping("/add")
    public String AddFlower(@Valid Flower flower, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "flower/add-flower";
        }

        Flower new_flower = new Flower(flower.getName(), flower.getType(),
                flower.getColor(), flower.getSmell(), flower.getCost());
        flowerRepository.save(new_flower);

        return "redirect:/flower/";
    }

    @PreAuthorize("hasAnyAuthority('FLORIST','ADMIN')")
    @GetMapping("/detail/{id}")
    public String detailFlower(
            @PathVariable Long id,
            Model model
    ) {
        Flower flower_obj = flowerRepository.findById(id).orElseThrow();
        model.addAttribute("one_flower", flower_obj);

        return "flower/info";
    }

    @PreAuthorize("hasAnyAuthority('FLORIST','ADMIN')")
    @GetMapping("/detail/{id}/del")
    public String delFlower(@PathVariable Long id,
                            Model model) {
        Flower flower_obj = flowerRepository.findById(id).orElseThrow();
        flowerRepository.delete(flower_obj);

        return "redirect:/flower/";
    }

    @PreAuthorize("hasAnyAuthority('FLORIST','ADMIN')")
    @GetMapping("/detail/{id}/upd")
    public String updateView(
            @PathVariable Long id,
            Model model
    ) {
        model.addAttribute("flower",
                flowerRepository.findById(id).orElseThrow());
        return "flower/update";
    }

    @PreAuthorize("hasAnyAuthority('FLORIST','ADMIN')")
    @PostMapping("/detail/{id}/upd")
    public String updateView(@Valid Flower flower, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "flower/update";
        }

        flowerRepository.save(flower);

        return "redirect:/flower/detail/" + flower.getId();
    }

    @GetMapping("/filter")
    public String filter(@RequestParam(name = "name") String name,
                         Model model) {
        List<Flower> flowerList = flowerRepository.findByName(name);
        model.addAttribute("flower_list", flowerList);

        return "flower/index";
    }
}