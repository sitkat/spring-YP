package com.example.demo.repositories;

import com.example.demo.models.Type;
import org.springframework.data.repository.CrudRepository;

public interface ToyTypeRepository extends CrudRepository<Type, Long> {
    Type findByNameType(String nameType);
}
