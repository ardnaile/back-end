package org.example;

public class Main {
    public static void main(String[] args) {
        var jogadorGerador = new JogadorGerador();

        for(int i = 0; i < 100; i++) {
            Jogador jogador = jogadorGerador.gerarJogador();
            System.out.println(jogador.toString());
        }
    }
}