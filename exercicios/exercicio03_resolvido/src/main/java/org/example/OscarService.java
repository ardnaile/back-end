package org.example;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OscarService {
    private List<Indicacao> indicados = new ArrayList<>();


    public void adicionarIndicacao(Indicavel indicavel, String categoria) {
        if (indicavel.isElegivel()) { // se isElegivel é true

            indicavel.incrementarIndicacoes();

            Indicacao novaIndicacao = new Indicacao(indicavel, categoria);
            indicados.add(novaIndicacao);

            System.out.println(indicados); // printando para debug!!
        } else {
            System.out.println("Este indicável não é elegível para indicação.");
        }
    }

    public List<Indicacao> listarIndicacoes() {
        return indicados;
    }
}
