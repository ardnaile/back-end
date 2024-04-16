package eliandra.primeirowebservice.controller;

import eliandra.primeirowebservice.JogadorGeradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JogadorController {
    @Autowired // essa anotação deixa o Spring gerenciar a dependência
    private JogadorGeradorService jogadorGeradorService;
    @GetMapping("/gerarJogador")
    public String gerarJogador() throws Exception {
        String nome = jogadorGeradorService.retornaPalavraDaURI("https://venson.net.br/resources/data/nomes.txt");
        String sobrenome = jogadorGeradorService.retornaPalavraDaURI("https://venson.net.br/resources/data/sobrenomes.txt");
        String posicao = jogadorGeradorService.retornaPalavraDaURI("https://venson.net.br/resources/data/posicoes.txt");
        String clube = jogadorGeradorService.retornaPalavraDaURI("https://venson.net.br/resources/data/clubes.txt");

        int idade = jogadorGeradorService.geraIdade(17, 40);

        return nome + " " + sobrenome + " É UM JOGADOR DE FUTEBOL BRASILEIRO DE "
                        + idade + " ANOS QUE ATUA COMO "
                        + posicao + " ATUALMENTE DEFENDENDO O "
                        + clube + ".";
    }
}
