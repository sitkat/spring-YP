package com.example.demo.controllers;

import com.example.demo.models.Chip;
import com.example.demo.models.Pet;
import com.example.demo.repositories.ChipRepository;
import com.example.demo.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class PetController {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private ChipRepository chipRepository;

    @GetMapping("/pet")
    public String pet(Model model) {
        Iterable<Chip> chips = chipRepository.findAll();
        ArrayList<Chip> chipArrayList = new ArrayList<>();
        for (Chip chip : chips) {
            if (chip.getPet() == null) {
                chipArrayList.add(chip);
            }
        }

        model.addAttribute("chip", chips);
        return "pet";
    }

    @PostMapping("/pet/add")
    public String petAdd(@RequestParam String name, @RequestParam String classification, @RequestParam String breed, @RequestParam String number, Model model) {
        System.out.println(name);
        Chip chip = chipRepository.findByNumber(number);
        System.out.println(chip.getId());
        Pet pet = new Pet(name, classification, breed, chip);
        petRepository.save(pet);
        return "redirect:/pet";
    }

}
