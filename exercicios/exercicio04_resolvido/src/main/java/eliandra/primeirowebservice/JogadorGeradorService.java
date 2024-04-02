package eliandra.primeirowebservice;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

@Service
public class JogadorGeradorService {
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
}