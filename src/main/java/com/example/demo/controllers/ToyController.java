package com.example.demo.controllers;

import com.example.demo.models.Toy;
import com.example.demo.models.Type;
import com.example.demo.repositories.ToyRepository;
import com.example.demo.repositories.ToyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/toy")
public class ToyController {
    @Autowired
    public ToyRepository toyRepository;

    @Autowired
    public ToyTypeRepository toyTypeRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Type> type = toyTypeRepository.findAll();
        Iterable<Toy> toyIterable = toyRepository.findAll();
        model.addAttribute("toy_list", toyIterable);
        model.addAttribute("type", type);

        return "toy/index";
    }

    @GetMapping("/add")
    public String addView(Toy toy, Model model) {
        model.addAttribute("type_list", toyTypeRepository.findAll());
        return "toy/add-toy";
    }

    @PostMapping("/add")
    public String AddToy(Model model,
                         @ModelAttribute("toy") @Valid Toy toy,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Iterable<Type> types = toyTypeRepository.findAll();
            model.addAttribute("type_list", types);
            return "toy/add-toy";
        }

        toyRepository.save(toy);
        return "redirect:/toy/";
    }

    @GetMapping("/detail/{id}")
    public String detailtoy(@PathVariable Long id, Model model) {
        Toy toy_obj = toyRepository.findById(id).orElseThrow();
        model.addAttribute("one_toy", toy_obj);

        return "toy/info";
    }

    @GetMapping("/detail/{id}/del")
    public String delToy(@PathVariable Long id, Model model) {
        Toy toy_obj = toyRepository.findById(id).orElseThrow();
        toyRepository.delete(toy_obj);

        return "redirect:/toy/";
    }

    @GetMapping("/detail/{id}/upd")
    public String updateView(@PathVariable Long id, Model model) {
        model.addAttribute("toy", toyRepository.findById(id).orElseThrow());
        return "toy/update";
    }

    @PostMapping("/detail/{id}/upd")
    public String updateView(@Valid Toy toy, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "toy/update";
        }

        toyRepository.save(toy);

        return "redirect:/toy/detail/" + toy.getId();
    }

    //    @PostMapping("/detail/{id}/upd")
//    public String updateView(
//            @PathVariable Long id,
//            @RequestParam String name,
//            @RequestParam String type,
//            @RequestParam String form,
//            @RequestParam Integer height,
//            @RequestParam Double cost
//    ) {
//        Toy toy = toyRepository.findById(id).orElseThrow();
//
//        toy.setName(name);
//        toy.setType(type);
//        toy.setForm(form);
//        toy.setHeight(height);
//        toy.setCost(cost);
//
//
//        toyRepository.save(toy);
//
//        return "redirect:/toy/detail/" + toy.getId();
//    }

    @GetMapping("/filter")
    public String filter(@RequestParam(name = "name") String name, Model model) {
        List<Toy> toyList = toyRepository.findByName(name);
        model.addAttribute("toy_list", toyList);

        return "toy/index";
    }
}
