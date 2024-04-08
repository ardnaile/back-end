package br.net.venson.login.models;

public class Pessoa {
    private String usuario;
    private String nome;
    private Short idade;

    public Pessoa(String usuario, String nome, Short idade) {
        this.usuario = usuario;
        this.nome = nome;
        this.idade = idade;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Short getIdade() {
        return idade;
    }

    public void setIdade(Short idade) {
        this.idade = idade;
    }
}
