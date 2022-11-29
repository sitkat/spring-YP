package com.example.demo.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
    private Collection<Toy> goods;

    @Column(name = "name")
    private String nameType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Toy> getGoods() {
        return goods;
    }

    public void setGoods(Collection<Toy> goods) {
        this.goods = goods;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
