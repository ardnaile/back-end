package com.example.demosemana14.mapper;

import com.example.demosemana14.dtos.AnimalDto;
import com.example.demosemana14.models.Animal;
import org.springframework.stereotype.Component;

@Component
public class AnimalMapper {
    public AnimalDto toDto(Animal animal) {
        return new AnimalDto(
                animal.getId(),
                animal.getNome(),
                animal.getTipo(),
                animal.getIdade(),
                animal.getAtivo()
        );
    }

    public Animal toEntity(AnimalDto animalDto) {
        // Construtor All Args
        /*
        return new Animal(
                animalDto.id(),
                animalDto.nome(),
                animalDto.tipo(),
                animalDto.ativo()
        );
         */
        // Builder
        return Animal.builder()
                .nome(animalDto.nome())
                .tipo(animalDto.tipo())
                .idade(animalDto.idade())
                .ativo(animalDto.ativo())
                .build();
    }
}
