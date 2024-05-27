package com.example.demosemana14;

import com.example.demosemana14.controllers.AnimalController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class DemoSemana14ApplicationTests {
	@Autowired
	AnimalController animalController;

	@Test
	void contextLoads() {
		assertThat(animalController).isNotNull();
	}

}
