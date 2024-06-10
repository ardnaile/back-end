package com.example.demosemana14.mappers;

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
                animal.getAtivo(),
                animal.getCor()
        );
    }

    public Animal toEntity(AnimalDto animalDto) {
        return Animal.builder()
                .nome(animalDto.nome())
                .tipo(animalDto.tipo())
                .idade(animalDto.idade())
                .ativo(animalDto.ativo())
                .build();
    }
}
