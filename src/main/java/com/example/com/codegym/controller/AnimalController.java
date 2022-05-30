package com.example.com.codegym.controller;

import com.example.com.codegym.model.Animal;
import com.example.com.codegym.service.animal.IAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class AnimalController {
    @Autowired
    private IAnimalService animalService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Animal>> getAll(){
        Iterable<Animal> animals = animalService.findAll();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Animal> createNewAnimal(@RequestBody Animal animal){
        animalService.save(animal);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/animal/{id}")
    public ResponseEntity<Animal> deletaAnimal(@PathVariable Long id){
        Optional<Animal> animalOptional = animalService.findById(id);
        animalService.remove(id);
        return new ResponseEntity<>(animalOptional.get(),HttpStatus.NO_CONTENT);
    }

    @PutMapping("/animal/{id}")
    public ResponseEntity<Animal> editAnimal(@PathVariable Long id, @RequestBody  Animal animal){
        Optional<Animal> animalOptional = animalService.findById(id);
        animal.setId(animalOptional.get().getId());
        if (!animalOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        animalService.save(animal);
        return new ResponseEntity<>(animalOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/animal/{id}")
    public ResponseEntity<Animal> findById(@PathVariable Long id){
        Optional<Animal> animalOptional = animalService.findById(id);
        if (!animalOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(animalOptional.get(),HttpStatus.OK);
    }
}
