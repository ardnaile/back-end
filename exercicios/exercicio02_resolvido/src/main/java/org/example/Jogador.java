package org.example;

public class Jogador {
    private String nome; // Esses são os atributos da classe, que vão estar no objeto
    private String sobrenome;
    private String posicao;
    private String clube;
    private int idade;

    // Objeto construtor

    public Jogador(String nome, String sobrenome, String posicao, String clube, int idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.posicao = posicao;
        this.clube = clube;
        this.idade = idade;
    }

    // Métodos getters

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

    // Gerando a descrição

    public String getDescricao() {
        return nome + " " + sobrenome + " É UM JOGADOR DE FUTEBOL BRASILEIRO DE "
                + idade + " ANOS QUE ATUA COMO "
                + posicao + ", ATUALMENTE DEFENDENDO O "
                + clube + ".";
    }
}
