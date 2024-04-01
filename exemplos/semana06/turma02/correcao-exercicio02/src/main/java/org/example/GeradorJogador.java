package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeradorJogador {
    private String[] listaDeNomes;
    private String[] listaDeSobrenomes;
    private String[] listaDePosicoes;
    private String[] listaDeClubes;

    public GeradorJogador() {

    }

    public void atualizaListas() {
        listaDeNomes = recuperaLista("nomes");
        listaDeSobrenomes = recuperaLista("sobrenomes");
        listaDePosicoes = recuperaLista("posicoes");
        listaDeClubes = recuperaLista("clubes");
    }

    public Jogador geraJogador() {
        Jogador jogador = new Jogador(
                escolheItemDaLista(listaDeNomes),
                escolheItemDaLista(listaDeSobrenomes),
                escolheItemDaLista(listaDePosicoes),
                escolheItemDaLista(listaDeClubes),
                geraNumeroAleatorio(17, 41)
        );
        return jogador;
    }

    public int geraNumeroAleatorio(int from, int to) {
        return (int) (from + (Math.random() * (to - from)));
    }

    public String[] recuperaLista(String nomeEntidade) {
        try {
            String uri = "https://venson.net.br/resources/data/" + nomeEntidade + ".txt";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String texto = response.body();
            String[] lista = texto.split("\n");
            return lista;
        } catch (Exception exception) {
            System.out.println("Erro ao baixar a lista");
            System.out.println(exception.getMessage());
            return new String[0];
        }
    }

    public String escolheItemDaLista(String[] lista) {
        int randomIndex = (int) Math.floor(Math.random() * lista.length);
        String nome = lista[randomIndex];
        return nome;
    }
}
