package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JogadorGerador {
    private String[] listaDeNomes;
    private String[] listaDeSobrenomes;
    private String[] listaDeClubes;
    private String[] listaDePosicoes;

    public JogadorGerador() {
        this.listaDeNomes = getListOfEntity("nomes");
        this.listaDeSobrenomes = getListOfEntity("sobrenomes");
        this.listaDeClubes = getListOfEntity("clubes");
        this.listaDePosicoes = getListOfEntity("posicoes");
    }

    public Jogador gerarJogador() {
        String nome = getValueFromArray(this.listaDeNomes);
        String sobrenome = getValueFromArray(this.listaDeSobrenomes);
        String posicao = getValueFromArray(this.listaDeClubes);
        String clube = getValueFromArray(this.listaDePosicoes);
        int idade = getRandomInt(17, 41);
        Jogador jogador = new Jogador(
                nome,
                sobrenome,
                posicao,
                clube,
                idade
        );
        return jogador;
    }

    private int getRandomInt(int from, int to) {
        return (int) (from + (Math.random() * (to - from)));
    }

    private String[] getListOfEntity(String entityName) {
        try {
            String uri = "https://venson.net.br/resources/data/" + entityName + ".txt";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) throw new Exception("Não foi possível encontrar a URL");
            String texto = response.body();
            String[] lista = texto.split("\n");
            System.out.println("Lista " + uri + " baixada com sucesso");
            return lista;
        } catch (Exception exception) {
            System.out.println("Erro ao fazer o download da entity " + entityName);
            return null;
        }
    }

    private String getValueFromArray(String[] lista) {
        int randomIndex = (int) Math.floor(Math.random() * lista.length);
        return lista[randomIndex];
    }
}
