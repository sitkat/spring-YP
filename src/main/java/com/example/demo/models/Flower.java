package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 2, max = 50, message = "Неверная строка")
    @NotBlank(message = "Строка не должна быть пустой")
    private String name;

    @Size(min = 2, max = 50, message = "Строка должна быть от 4 до 50 символов")
    @NotNull()
    private String type;

    private String color;

    private String smell;

    private Double cost;

    public Flower() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmell() {
        return smell;
    }

    public void setSmell(String smell) {
        this.smell = smell;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Flower(String name, String type, String color, String smell, Double cost) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.smell = smell;
        this.cost = cost;
    }
}
