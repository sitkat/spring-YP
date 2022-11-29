package com.example.demo.repositories;

import com.example.demo.models.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
    Subject findByName(String name);
}
