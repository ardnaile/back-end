package org.example;

public class Jogador {
    private String nome;
    private String sobrenome;
    private String posicao;
    private String clube;
    private int idade;

    public Jogador(String nome, String sobrenome, String posicao, String clube, int idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.posicao = posicao;
        this.clube = clube;
        this.idade = idade;
    }

    // Métodos para acessar cada uma das infos
    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getClube() {
        return clube;
    }

    public int getIdade() {
        return idade;
    }

    // Gerando a descrição igual no exercício 01
    public String getDescricao() {
        return nome + " " + sobrenome + " É UM JOGADOR DE FUTEBOL BRASILEIRO DE "
                + idade + " ANOS QUE ATUA COMO "
                + posicao + ", ATUALMENTE DEFENDENDO O "
                + clube + ".";
    }
}

