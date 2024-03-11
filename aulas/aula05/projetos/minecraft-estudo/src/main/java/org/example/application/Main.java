package org.example.application;

import org.example.game.Bloco;
import org.example.game.Item;
import org.example.game.Jogador;
import org.example.game.Mundo;

public class Main {
    public static void main(String[] args) {
        Mundo mundo = new Mundo();
        Jogador jogador = new Jogador();

        jogador.mover(10, 16);
        Bloco bloco = mundo.getBloco(10, 16);
        System.out.println(jogador.getPosicao());

        Item item = jogador.minerar(bloco);
        if (item != null) {
            jogador.coleta(item);
        }

        for (Item itemInventario : jogador.getInventario()) {
            System.out.println(itemInventario.getNome());
        }
    }
}