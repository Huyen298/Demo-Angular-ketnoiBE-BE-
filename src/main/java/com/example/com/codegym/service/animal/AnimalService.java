package com.example.com.codegym.service.animal;

import com.example.com.codegym.model.Animal;
import com.example.com.codegym.repository.IAnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnimalService implements IAnimalService {

    @Autowired
    private IAnimalRepository animalRepository;

    @Override
    public Iterable findAll() {
        return animalRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return animalRepository.findById(id);
    }

    @Override
    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public void remove(Long id) {
        animalRepository.deleteById(id);
    }

}
