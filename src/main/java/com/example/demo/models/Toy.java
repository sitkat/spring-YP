package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Toy {
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
    private String form;

    @NotNull(message = "Заполните поле")
    @DecimalMin(value = "0.0", message = "Число не может быть отрицательным", inclusive = false)
    @DecimalMax(value = "200.0", message = "Некорректный ввод", inclusive = false)
    private Integer height;

    @NotNull(message = "Заполните поле")
    @DecimalMin(value = "0.0", message = "Число не может быть отрицательным", inclusive = false)
    @DecimalMax(value = "99999.99", message = "Некорректный ввод", inclusive = false)
    private Double cost;

    public Toy() {
    }

    public Toy(String name, String type, String form, Integer height, Double cost) {
        this.name = name;
        this.type = type;
        this.form = form;
        this.height = height;
        this.cost = cost;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
