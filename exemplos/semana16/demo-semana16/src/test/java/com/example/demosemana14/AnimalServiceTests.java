package com.example.demosemana14;

import com.example.demosemana14.dtos.AnimalDto;
import com.example.demosemana14.models.Animal;
import com.example.demosemana14.repositories.AnimalRepository;
import com.example.demosemana14.services.AnimalService;
import com.example.demosemana14.services.CorAleatoriaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("testing")
class AnimalServiceTests {
	@Mock
	CorAleatoriaService corAleatoriaService;
	@Autowired
	AnimalRepository animalRepository;
	@Autowired
	@InjectMocks
	AnimalService animalService;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("Retorna lista de animais")
	public void getAllAnimais() throws Exception {
		Animal animal = new Animal(
				null,
				"teste",
				"gato",
				1,
				true,
				null
		);
		animalRepository.save(animal);
		List<AnimalDto> list = animalService.getAllAnimais(0, new ArrayList<>());
		assertThat(list).hasSize(1);
	}

	@Test
	@DisplayName("Retorna lista de animais vazia")
	public void getEmptyListAnimais() throws Exception {
		List<AnimalDto> list = animalService.getAllAnimais(0, new ArrayList<>());
		assertThat(list).hasSize(0);
	}

	@Test
	@DisplayName("Retorna pagina com no máximo 10 animais")
	public void getTenAnimaisPerList() throws Exception {
		for (int i = 0; i < 100; i++) {
			createFakeAnimal();
		}
		List<AnimalDto> list = animalService.getAllAnimais(0, new ArrayList<>());
		assertThat(list).hasSize(10);
	}

	@Test
	public void saveAnimal() throws Exception {
		when(corAleatoriaService.getCorAleatoria()).thenReturn("verde");
		AnimalDto animalDto = new AnimalDto(
				null,
				"teste",
				"gato",
				1,
				true,
				null
		);
		AnimalDto savedAnimal = animalService.saveAnimal(animalDto);
		assertThat(savedAnimal).isExactlyInstanceOf(AnimalDto.class);
		assertThat(savedAnimal.nome()).isEqualTo("teste");
		assertThat(savedAnimal.ativo()).isTrue();
		assertThat(savedAnimal.tipo()).isEqualTo("gato");
		assertThat(savedAnimal.cor()).isEqualTo("verde");
	}

	private void createFakeAnimal() {
		Animal animal = new Animal(
				null,
				"teste",
				"gato",
				1,
				true,
				null
		);
		animalRepository.save(animal);
	}

}
