package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    public static String retornaPalavraDaURI(String minhaUri) throws Exception{
        // Puxando o arquivo de texto usando HTTP
        // estudar melhor cada linha
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(minhaUri)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String lista = response.body();

        // pegamos a lista e dividimos
        String[] palavras = lista.split("\n");
        // o indice aleatório vai ser um número aleatório no range do tamanho da lista gerada
        int indexAleatorio = (int) Math.floor(Math.random() * palavras.length);
        // pegamos uma palavra da nova lista palavras, no índice aleatório que definimos
        String palavra = palavras[indexAleatorio];

        palavra = palavra.replace("\"", "");
        palavra = palavra.replace(",", "");
        palavra = palavra.toUpperCase();

        return palavra;
    }
    // função para gerar idade aleatória, com "range manual"
    public static int geraIdade(int menor, int maior){
        int diferenca = maior - menor;
        int aleatorio = (int) Math.floor(Math.random() * diferenca);
        return aleatorio + menor;
    }
    // parte principal que vai rodar realmente o programa e puxar as funções criadas
    public static void main(String[] args) throws Exception {
        String nome = retornaPalavraDaURI("https://venson.net.br/resources/data/nomes.txt");
        String sobrenome = retornaPalavraDaURI("https://venson.net.br/resources/data/sobrenomes.txt");
        String posicao = retornaPalavraDaURI("https://venson.net.br/resources/data/posicoes.txt");
        String clube = retornaPalavraDaURI("https://venson.net.br/resources/data/clubes.txt");

        int idade = geraIdade(17, 40);

        System.out.println(
                nome + " " + sobrenome + " É UM JOGADOR DE FUTEBOL BRASILEIRO DE "
                + idade + " ANOS QUE ATUA COMO "
                + posicao + " ATUALMENTE DEFENDENDO O "
                + clube + "."
        );
        // System.out.printf("%s %s", nome, sobrenome);
        // dúvida: por que a posição ficou com aspas e vírgula?
    }
}