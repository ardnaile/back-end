package org.example;

import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

@Repository
public class FileStorageService implements StorageService{
    @Override
    public void store(Pokemon pokemon) {
        try {
            FileOutputStream file = new FileOutputStream("pc.txt", true);
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.append(pokemon.getNome() + ";" + pokemon.getNivel());
            printWriter.close();
        } catch (FileNotFoundException exception) {
            System.out.println("O arquivo não abriu");
        }
    }

    @Override
    public Pokemon retrieve() {
        return null;
    }
}
