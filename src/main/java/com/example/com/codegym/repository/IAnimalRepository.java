package com.example.com.codegym.repository;

import com.example.com.codegym.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnimalRepository extends CrudRepository<Animal, Long> {
}
