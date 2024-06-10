package com.example.demosemana14.services;

import com.example.demosemana14.dtos.AnimalDto;
import com.example.demosemana14.mappers.AnimalMapper;
import com.example.demosemana14.models.Animal;
import com.example.demosemana14.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;
    @Autowired
    AnimalMapper animalMapper;
    @Autowired
    CorAleatoriaService corAleatoriaService;

    public AnimalDto saveAnimal(AnimalDto animalDto) {
        Animal animal = animalMapper.toEntity(animalDto);
        animal.setCor(corAleatoriaService.getCorAleatoria());
        Animal savedAnimal = animalRepository.save(animal);
        return animalMapper.toDto(savedAnimal);
    }

    public List<AnimalDto> getAllAnimais(Integer pageNumber, List<String> sortList) {
        List<Sort.Order> orderList = sortList.stream().map((sort) -> {
            return new Sort.Order(Sort.Direction.ASC, sort);
        }).toList();
        Pageable page = PageRequest.of(pageNumber, 10, Sort.by(orderList));
        Page<Animal> list = animalRepository.findAll(page);
        return list.stream().map(animalMapper::toDto).toList();
    }


}
