package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PokemonService {
    ArrayList<Pokemon> minhaEquipe = new ArrayList<>();
    @Autowired
    StorageService storageService;

    public void capturar(Pokemon pokemon) {
        System.out.println("O pokemon " + pokemon.getNome() + " foi capturado");
        if (minhaEquipe.size() >= 6) {
            storageService.store(pokemon);
            System.out.println("Foi enviado para o PC (StorageService)");
        } else {
            minhaEquipe.add(pokemon);
            System.out.println("Foi enviado para equipe");
        }
    }
}
