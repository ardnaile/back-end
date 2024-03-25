package org.example;

import org.springframework.stereotype.Repository;

import java.io.FileOutputStream;
import java.io.PrintWriter;

@Repository
public class ArquivoArmazenamentoRepositorio implements ArmazenamentoRepositorio{
    @Override
    public void armazenar(String texto) {
        try {
            FileOutputStream arquivo = new FileOutputStream("pc.txt", true);
            PrintWriter printWriter = new PrintWriter(arquivo);
            printWriter.append(texto);
            printWriter.close();
        } catch (Exception exception) {
            System.out.println("Ferrou! O arquivo não abriu!");
        }
    }

    @Override
    public String recuperar() {
        return "";
    }
}
