package org.example.game;

public class Mundo {
    private Bloco[] mapa = new Bloco[64*64];

    public Mundo() {
        gerarMapa();
    }

    public void gerarMapa() {
        for (int x = 0; x < 64; x++) {
            for (int y = 0; y < 64; y++){
                Bloco bloco = new FerroBloco();
                mapa[x * y] = bloco;
            }
        }
    }

    public Bloco getBloco(int x, int y) {
        if (x < 0 || y < 0 || x > 63 || y > 63) {
            System.out.println("Bloco fora dos limites");
            return null;
        }
        return mapa[x * y];
    }

    public Bloco getBloco(int i) {
        if (i > mapa.length - 1) {
            System.out.println("Bloco fora dos limites");
            return null;
        }
        return mapa[i];
    }
}
