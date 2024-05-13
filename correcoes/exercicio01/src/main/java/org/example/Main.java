package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    public static void main(String[] args) throws Exception {
        String nome = getRandomValueFromURI("https://venson.net.br/resources/data/nomes.txt");
        String sobrenome = getRandomValueFromURI("https://venson.net.br/resources/data/sobrenomes.txt");
        String posicao = getRandomValueFromURI("https://venson.net.br/resources/data/posicoes.txt");
        String time = getRandomValueFromURI("https://venson.net.br/resources/data/clubes.txt");
        int idade = getRandomInt(17, 41);
        System.out.println(
            nome + " "
            + sobrenome + " é um futebolista brasileiro de "
            + idade + " anos que atua como "
            + posicao + ". Atualmente defende o "
            + time + "."
        );
    }

    public static int getRandomInt(int from, int to) {
        return (int) (from + (Math.random() * (to - from)));
    }

    public static String getRandomValueFromURI(String uri) throws Exception{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String texto = response.body();
        String[] nomes = texto.split("\n");
        int randomIndex = (int) Math.floor(Math.random() * nomes.length);
        String nome = nomes[randomIndex];
        return nome;
    }


}