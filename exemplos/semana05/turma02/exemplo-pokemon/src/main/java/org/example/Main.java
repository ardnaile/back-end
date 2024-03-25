package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        PokemonService pokemonService = context.getBean(PokemonService.class);

        for (int i = 0; i < 10; i++) {
            Pokemon pokemon = context.getBean(Pokemon.class, "CHARIZARD", 12);
            pokemonService.capturar(pokemon);
        }

        // Pokemon pokemon = new Pokemon("CHARMANDER", 15);
    }
}