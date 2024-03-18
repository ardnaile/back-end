package org.example.aplicacao;

import org.example.jogo.Bloco;
import org.example.jogo.FerroBloco;
import org.example.jogo.Item;

public class Main {
    public static void main(String[] args) {
        FerroBloco meuBloco = new FerroBloco();
        Item drop = meuBloco.destruir(50);
        if (drop == null) {
            System.out.println("Não dropou nada!");
        } else {
            System.out.println("Dropou o " + drop.getNome());
        }
    }
}