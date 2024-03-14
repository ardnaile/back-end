package org.example.jogo;

public class Bloco {
    private String nome = "Bloco Genérico";

    public Item destruir() {
        System.out.println("Bloco Destruido!");
        return null;
    }
}
