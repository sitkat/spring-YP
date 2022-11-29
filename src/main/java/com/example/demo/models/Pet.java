package com.example.demo.models;


import javax.persistence.*;

@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String classification;
    private String breed;
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="chip_id")
    private Chip chip;

    public Pet() {
    }

    public Pet(String name, String classification, String breed, Chip chip) {
        this.name = name;
        this.classification = classification;
        this.breed = breed;
        this.chip = chip;
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

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Chip getChip() {
        return chip;
    }

    public void setChip(Chip chip) {
        this.chip = chip;
    }
}
