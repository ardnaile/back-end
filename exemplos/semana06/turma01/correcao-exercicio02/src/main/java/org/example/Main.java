package org.example;

public class Main {
    public static void main(String[] args) {
        GeradorJogador gerador = new GeradorJogador();

        for (int i = 0; i < 10; i++) {
            Jogador jogador = gerador.geraJogador();
            System.out.println(jogador);
        }
    }
}