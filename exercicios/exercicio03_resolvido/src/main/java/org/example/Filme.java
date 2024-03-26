package org.example;

public class Filme implements Indicavel {
    private boolean elegivel;
    private int numeroDeIndicacoes;

    // Getters e setters

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

