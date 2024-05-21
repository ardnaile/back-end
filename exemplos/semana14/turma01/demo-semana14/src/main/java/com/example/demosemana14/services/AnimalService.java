package com.example.demosemana14.services;

import com.example.demosemana14.dtos.AnimalDto;
import com.example.demosemana14.mapper.AnimalMapper;
import com.example.demosemana14.models.Animal;
import com.example.demosemana14.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;
    @Autowired
    AnimalMapper animalMapper;

    // Retorna uma lista de animais
    public List<AnimalDto> getAllAnimals(Integer pagina, Integer resultados, List<String> sortBy) {
        List<Sort.Order> orderByList = sortBy.stream().map((nomeAtributo) -> {
            return new Sort.Order(Sort.Direction.ASC, nomeAtributo);
        }).toList();
        // Configura a paginacao
        Pageable pageConfig = PageRequest.of(pagina, resultados, Sort.by(orderByList));
        // procura por todos os animais
        Page<Animal> listaAnimais = animalRepository.findAll(pageConfig);
        // converte cada um para dto
        List<AnimalDto> listaAnimaisDto = listaAnimais.stream().map(animalMapper::toDto).toList();
        // retorna a lista de dtos
        return listaAnimaisDto;
    }

    // Retorna um animal pelo ID
    public AnimalDto getAnimalById(UUID id) {
        // procura por um animal
        Optional<Animal> animal = animalRepository.findById(id);
        // gera um erro se nao existir
        if (animal.isEmpty()) throw new RuntimeException("O animal não existe");
        // converte o resultado para dto e retorna
        return animalMapper.toDto(animal.get());
    }

    // Salva um novo animal
    public AnimalDto saveAnimal(AnimalDto animalDto) {
        // converte o dto para entidade
        Animal animal = animalMapper.toEntity(animalDto);
        // salva a entidade no repositorio
        Animal animalSalvo = animalRepository.save(animal);
        // converte o retorno para dto retorna o dto
        return animalMapper.toDto(animalSalvo);
    }

}
