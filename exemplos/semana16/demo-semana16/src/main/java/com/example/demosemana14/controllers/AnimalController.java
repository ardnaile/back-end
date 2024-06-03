package com.example.demosemana14.controllers;

import com.example.demosemana14.dtos.AnimalDto;
import com.example.demosemana14.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {
    @Autowired
    AnimalService animalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalDto saveAnimal(@RequestBody AnimalDto animalDto) {
        return animalService.saveAnimal(animalDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDto> getAllAnimaisByPageAndSort(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "") List<String> sortBy) {
        return animalService.getAllAnimais(page, sortBy);
    }
}
