package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        Pokemon pokemon1 = context.getBean(Pokemon.class, "BULBASSAUR", 10);
        Pokemon pokemon2 = context.getBean(Pokemon.class, "CHARMANDER", 10);

        PokemonService pokemonService = context.getBean(PokemonService.class);
        pokemonService.capturar(pokemon1);
    }
}