package com.example.demo.repositories;

import com.example.demo.models.Toy;
import org.springframework.data.repository.CrudRepository;

public interface ToyRepository extends CrudRepository<Toy, Long> {

}
