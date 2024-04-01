package org.example;

public class Main {
    public static void main(String[] args) {
        /*
        Jogador jogador = new Jogador(
                "Messi",
                "Andreas",
                "Atacante",
                "Inter Miami",
                36
        );
         */

        GeradorJogador gerador = new GeradorJogador();
        gerador.atualizaListas();

        for (int i = 0; i < 10; i++) {
            Jogador jogador = gerador.geraJogador();
            System.out.println(jogador.toString());
        }
    }
}