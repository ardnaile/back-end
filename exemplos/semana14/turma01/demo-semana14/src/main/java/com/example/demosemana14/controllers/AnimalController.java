package com.example.demosemana14.controllers;

import com.example.demosemana14.dtos.AnimalDto;
import com.example.demosemana14.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AnimalController {
    @Autowired
    AnimalService animalService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDto> getAllAnimals(
            @RequestParam(defaultValue = "0") Integer pagina,
            @RequestParam(defaultValue = "5") Integer resultados,
            @RequestParam(defaultValue = "nome") List<String> sortBy) {
        return animalService.getAllAnimals(pagina, resultados, sortBy);
    }

    // localhost:8080/6464fgh-fg-hfghfghfgh
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalDto getAnimalById(@PathVariable UUID id) {
        return animalService.getAnimalById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalDto saveAnimal(@RequestBody AnimalDto animalDto) {
        return animalService.saveAnimal(animalDto);
    }
}
