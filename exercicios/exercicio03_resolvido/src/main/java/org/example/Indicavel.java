package org.example;

/*
criando um "tipo" novo de variável
uma interface é uma coleçao de métodos, comportamentos que uma classe deve implementar

 */
public interface Indicavel {
    boolean isElegivel();
    void setElegivel(boolean elegivel);
    int getNumeroDeIndicacoes();
    void incrementarIndicacoes();
}

