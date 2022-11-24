package com.example.demo.repositories;

import com.example.demo.models.Flower;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlowerRepository extends CrudRepository<Flower, Long> {
    public List<Flower> findByName(String name);

}
