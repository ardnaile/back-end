package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeradorJogador {
    private String[] listaNomes;
    private String[] listaSobrenomes;
    private String[] listaPosicoes;
    private String[] listaClubes;

    public GeradorJogador() {
        this.listaNomes = recuperaLista("nomes");
        this.listaSobrenomes = recuperaLista("sobrenomes");
        this.listaPosicoes = recuperaLista("posicoes");
        this.listaClubes = recuperaLista("clubes");
    }

    public Jogador geraJogador() {
        String nome = escolheDaLista(listaNomes);
        String sobrenome = escolheDaLista(listaSobrenomes);
        String posicao = escolheDaLista(listaPosicoes);
        String clube = escolheDaLista(listaClubes);
        Integer idade = geraNumeroAleatorio(17, 41);
        Jogador jogador = new Jogador(
                nome,
                sobrenome,
                posicao,
                clube,
                idade
        );
        return jogador;
    }

    public static int geraNumeroAleatorio(int from, int to) {
        return (int) (from + (Math.random() * (to - from)));
    }

    public String escolheDaLista(String[] lista) {
        int randomIndex = (int) Math.floor(Math.random() * lista.length);
        String palavra = lista[randomIndex];
        return palavra;
    }

    private String[] recuperaLista(String nomeEntidade) {
        try {
            System.out.println("Recuperando lista " + nomeEntidade);
            String uri = "https://venson.net.br/resources/data/" + nomeEntidade + ".txt";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String texto = response.body();
            String[] lista = texto.split("\n");
            return lista;
        } catch (Exception exception) {
            System.out.println("Erro ao fazer o download da lista");
            System.out.println(exception.getMessage());
            return new String[0];
        }
    }
}
