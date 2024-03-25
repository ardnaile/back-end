package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PokemonService {
    ArrayList<Pokemon> equipe = new ArrayList<>();
    @Autowired
    ArmazenamentoRepositorio armazenamentoRepositorio;

    public void capturar(Pokemon pokemon) {
        System.out.println("O pokemon " + pokemon.getNome() + " foi capturado!");
        if (equipe.size() >= 0) {
            armazenamentoRepositorio.armazenar(pokemon.getNome());
        } else {
            equipe.add(pokemon);
        }
    }
}
