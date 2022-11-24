package com.example.demo.repositories;

import com.example.demo.models.Flower;
import com.example.demo.models.Toy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToyRepository extends CrudRepository<Toy, Long> {
    public List<Toy> findByName(String name);
}
