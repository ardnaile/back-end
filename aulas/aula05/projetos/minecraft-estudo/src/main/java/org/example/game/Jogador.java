package org.example.game;

import java.util.ArrayList;

public class Jogador {
    private String nome = "Jogador1";
    private int posicaoX = 0;
    private int posicaoY = 0;
    private ArrayList<Item> inventario = new ArrayList();

    public Item minerar(Bloco bloco) {
        Item item = bloco.destruir();
        return item;
    }

    public String getPosicao() {
        return nome + " está em (" + this.posicaoX + ", " + this.posicaoY + ")";
    }

    public void mover(int x, int y) {
        posicaoX += x;
        posicaoY += y;
    }

    public void coleta(Item item) {
        inventario.add(item);
    }

    public ArrayList<Item> getInventario() {
        return this.inventario;
    }
}
