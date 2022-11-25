package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Строка не должна быть пустой")
    @Size(min = 2, max = 50, message = "Неверная строка")
    private String name;

    @NotBlank(message = "Строка не должна быть пустой")
    @Size(min = 4, max = 50, message = "Неверная строка")
    private String type;

    @NotBlank(message = "Строка не должна быть пустой")
    @Size(min = 4, max = 50, message = "Неверная строка")
    private String color;

    @NotBlank(message = "Строка не должна быть пустой")
    @Size(min = 4, max = 50, message = "Неверная строка")
    private String smell;

    @NotNull(message = "Заполните поле")
    @DecimalMin(value = "0.0", message = "Число не может быть отрицательным", inclusive = false)
    @DecimalMax(value = "99999.99", message = "Некорректный ввод", inclusive = false)
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
