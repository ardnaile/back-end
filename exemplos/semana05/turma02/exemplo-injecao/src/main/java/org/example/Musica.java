package org.example;

public class Musica {
    public String nome = "esse cara sou eu";
    public Artista artista;

    public Musica(Artista artista) {
        System.out.println("Construindo objeto musica");
        this.artista = artista;
    }
}
