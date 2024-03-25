package org.example;

// criando uma classe de objetos do tipo Indicavel
public class Filme implements Indicavel {
    private boolean elegivel;
    private int numeroDeIndicacoes;

    // Construtor, getters e setters

    @Override
    public boolean isElegivel() {
        return elegivel;
    }

    @Override
    public void setElegivel(boolean elegivel) {
        this.elegivel = elegivel;
    }

    @Override
    public int getNumeroDeIndicacoes() {
        return numeroDeIndicacoes;
    }

    @Override
    public void incrementarIndicacoes() {
        this.numeroDeIndicacoes++;
    }
}

