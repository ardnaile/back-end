package org.example;

public class Ator implements Indicavel {
    private boolean elegivel;
    private int numeroDeIndicacoes;

    @Override
    public boolean isElegivel() {
        return elegivel;
    }

    @Override
    public void setElegivel(boolean elegivel) { // setter do elegível
        this.elegivel = elegivel;
    }

    @Override
    public int getNumeroDeIndicacoes() { // getter
        return numeroDeIndicacoes;
    }

    @Override
    /*
    @Override é uma anotação usada para indicar que um método está substituindo o da classe pai
    */
    public void incrementarIndicacoes() { // método para incrementar o número de indicação
        this.numeroDeIndicacoes++;
    }
}