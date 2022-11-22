package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Star {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String class_star;
    private Integer lumen;


    public Star() {
    }

    public Star(String name, String class_star, Integer lumen) {
        this.name = name;
        this.class_star = class_star;
        this.lumen = lumen;
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

    public String getClass_star() {
        return class_star;
    }

    public void setClass_star(String class_star) {
        this.class_star = class_star;
    }

    public Integer getLumen() {
        return lumen;
    }

    public void setLumen(Integer lumen) {
        this.lumen = lumen;
    }
}
