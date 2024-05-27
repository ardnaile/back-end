package com.example.demosemana14;

import com.example.demosemana14.dtos.AnimalDto;
import com.example.demosemana14.models.Animal;
import com.example.demosemana14.repositories.AnimalRepository;
import com.example.demosemana14.services.AnimalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("testing")
public class AnimalControllerTest {
    @Autowired
    AnimalService animalService;
    @Autowired
    AnimalRepository animalRepository;

    @Test
    @DisplayName("Retorna apenas 10 elementos")
    public void getAllAnimalsTest() {
        for (int i = 0; i < 100; i++) {
            createFakeAnimal();
        }
        ArrayList<String> sortBy = new ArrayList<>();
        sortBy.add("nome");
        List<AnimalDto> lista = animalService.getAllAnimals(0, 10, sortBy);
        assertThat(lista).hasSize(10);
        assertThat(lista).hasSameClassAs(List.class);
        assertThat(lista.get(0)).hasSameClassAs(Animal.class);
    }

    private void createFakeAnimal() {
        Animal fakeAnimal = new Animal();
        animalRepository.save(fakeAnimal);
    }
}
