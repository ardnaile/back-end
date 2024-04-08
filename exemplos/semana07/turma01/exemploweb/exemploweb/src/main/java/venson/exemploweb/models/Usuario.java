package venson.exemploweb.models;

public class Usuario {
    private String nome;
    private Integer idade;
    private String descricao;

    public Usuario(String nome, Integer idade, String descricao) {
        this.nome = nome;
        this.idade = idade;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
