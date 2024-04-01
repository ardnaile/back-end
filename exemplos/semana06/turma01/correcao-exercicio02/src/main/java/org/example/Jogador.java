package org.example;

public class Jogador {
    private String nome;
    private String sobrenome;
    private String posicao;
    private String clube;
    private Integer idade;

    public Jogador(String nome, String sobrenome, String posicao, String clube, Integer idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.posicao = posicao;
        this.clube = clube;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return this.nome + " "
                + this.sobrenome + " é um futebolista brasileiro de "
                + this.idade + " anos que atua como "
                + this.posicao + ". Atualmente defende o "
                + this.clube + ".";
    }
}
