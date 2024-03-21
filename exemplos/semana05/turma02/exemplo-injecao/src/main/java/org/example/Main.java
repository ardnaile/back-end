package org.example;

public class Main {
    public static void main(String[] args) {
        Artista artista = new Artista();
        Musica musica1 = new Musica(artista);
        Musica musica2 = new Musica(artista);
        System.out.println(musica1.artista.nome);
        System.out.println(musica2.artista.nome);
        System.out.println(musica1.artista == musica2.artista);
    }
}