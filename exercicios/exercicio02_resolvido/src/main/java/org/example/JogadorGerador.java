package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Nessa classe, temos os métodos usados para criar o jogador

public class JogadorGerador {
    private static String textoNome;
    private static String textoSobrenome;
    private static String textoPosicao;
    private static String textoClube;

    private static void realizaRequisicoes() throws Exception {
        textoNome = retornaListaDaURI("https://venson.net.br/resources/data/nomes.txt");
        textoSobrenome = retornaListaDaURI("https://venson.net.br/resources/data/sobrenomes.txt");
        textoPosicao = retornaListaDaURI("https://venson.net.br/resources/data/posicoes.txt");
        textoClube = retornaListaDaURI("https://venson.net.br/resources/data/clubes.txt");
    }

    // Método que cria um array com objetos do tipo Jogador

    public static Jogador[] gerarJogadores(int quantidade) throws Exception { // Jogador[] é o retorno, o array
        realizaRequisicoes();

        Jogador[] jogadores = new Jogador[quantidade]; // Aqui é criado o array

        for (int i = 0; i < quantidade; i++) { // Percorre de 0 até quantidade-1
            jogadores[i] = new Jogador(
                    retornaPalavradDaLista(textoNome),
                    retornaPalavradDaLista(textoSobrenome),
                    retornaPalavradDaLista(textoPosicao),
                    retornaPalavradDaLista(textoClube),
                    geraIdade(17, 40)
            );
        }
        return jogadores;
    }

    // Método para retornar o texto (string) a partir da URI

    private static String retornaListaDaURI(String minhaUri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(minhaUri)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String texto = response.body();
        return texto;
    }

    // Método para retornar uma palavra (pedaço da string) a partir do texto

    private static String retornaPalavradDaLista(String texto) throws Exception{
        String[] palavras = texto.split("\n");
        int indexAleatorio = (int) Math.floor(Math.random() * palavras.length);
        String palavra = palavras[indexAleatorio];
        palavra = palavra.replace("\"", "");
        palavra = palavra.replace(",", "");
        palavra = palavra.toUpperCase();
        return palavra;
    }

    // Método para gerar idade

    public static int geraIdade(int menor, int maior) {
        int diferenca = maior - menor;
        int aleatorio = (int) Math.floor(Math.random() * diferenca);
        return aleatorio + menor;
    }
}
