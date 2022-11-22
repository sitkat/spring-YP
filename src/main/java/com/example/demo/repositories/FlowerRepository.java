package com.example.demo.repositories;

import com.example.demo.models.Flower;
import org.springframework.data.repository.CrudRepository;

public interface FlowerRepository extends CrudRepository<Flower, Long> {

}
