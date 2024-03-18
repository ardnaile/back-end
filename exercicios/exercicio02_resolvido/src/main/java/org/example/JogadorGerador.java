package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Essa primeira classe é onde temos os métodos para criar o jogador
public class JogadorGerador {
    private static String nome;
    private static String sobrenome;
    private static String posicao;
    private static String clube;

    private static void realizaRequisicoes() throws Exception {
        nome = retornaListaDaURI("https://venson.net.br/resources/data/nomes.txt");
        sobrenome = retornaListaDaURI("https://venson.net.br/resources/data/sobrenomes.txt");
        posicao = retornaListaDaURI("https://venson.net.br/resources/data/posicoes.txt");
        clube = retornaListaDaURI("https://venson.net.br/resources/data/clubes.txt");
    }

    // método que cria um array de jogadores
    public static Jogador[] gerarJogadores(int quantidade) throws Exception { // jogador[] é o retorno, o array
        realizaRequisicoes();
        Jogador[] jogadores = new Jogador[quantidade]; // aqui é criado o array
        for (int i = 0; i < quantidade; i++) { // percorre de 0 até quantidade-1
            jogadores[i] = new Jogador(
                    retornaPalavradDaLista(nome),
                    retornaPalavradDaLista(sobrenome),
                    retornaPalavradDaLista(posicao),
                    retornaPalavradDaLista(clube),
                    geraIdade(17, 40)
            );
        }
        return jogadores;
    }

    // método para retornar uma palavra a partir das listas da URI, igual o do exercício 01
    private static String retornaListaDaURI(String minhaUri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(minhaUri)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String lista = response.body();
        return lista;
    }
    private static String retornaPalavradDaLista(String lista) throws Exception{
        String[] palavras = lista.split("\n");
        int indexAleatorio = (int) Math.floor(Math.random() * palavras.length);
        String palavra = palavras[indexAleatorio];
        palavra = palavra.replace("\"", "");
        palavra = palavra.replace(",", "");
        palavra = palavra.toUpperCase();
        return palavra;
    }

    // método para gerar idade, igual o do exercício 01
    public static int geraIdade(int menor, int maior) {
        int diferenca = maior - menor;
        int aleatorio = (int) Math.floor(Math.random() * diferenca);
        return aleatorio + menor;
    }
}
