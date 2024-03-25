package org.example;

public class Indicacao {
    private Indicavel indicavel;
    private String categoria;

    // Construtor
    public Indicacao(Indicavel indicavel, String categoria) {
        this.indicavel = indicavel;
        this.categoria = categoria;
    }

    // Getters e Setters
    public Indicavel getIndicavel() { // pega o atributo Indicavel passado na criação do objeto
        return indicavel;
    }

    public void setIndicavel(Indicavel indicavel) { // setando o atributo indicavel passado na criação do objeto
        this.indicavel = indicavel;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
/*
podemos criar uma nova indicação assim:

Indicacao indicacao = new Indicacao(new Filme(), "Melhor Filme");

 */
