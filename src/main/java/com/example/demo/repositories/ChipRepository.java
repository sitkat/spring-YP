package com.example.demo.repositories;

import com.example.demo.models.Chip;
import org.springframework.data.repository.CrudRepository;

public interface ChipRepository extends CrudRepository<Chip, Long> {
    Chip findByNumber(String number);
}
