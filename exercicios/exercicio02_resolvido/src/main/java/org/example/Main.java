package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    public static void main(String[] args) {
        try {
            Jogador[] jogadores = JogadorGerador.gerarJogadores(3); // Gera 3 jogadores
            for (Jogador jogador : jogadores) {
                System.out.println(jogador.getDescricao()); // Imprime a descrição de cada jogador
            }
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao gerar os jogadores: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
