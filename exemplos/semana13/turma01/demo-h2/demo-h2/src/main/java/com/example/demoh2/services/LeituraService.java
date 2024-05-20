package com.example.demoh2.services;

import com.example.demoh2.models.Leitura;
import com.example.demoh2.repositories.LeituraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LeituraService {
    @Autowired
    LeituraRepository leituraRepository;

    // Lista todas as leituras
    public List<Leitura> retornaTudo() {
        return leituraRepository.findAll();
    }

    // Salva uma leitura recebida como parametro
    public Leitura salva(Leitura leitura) {
        return leituraRepository.save(leitura);
    }

    // Lista uma leitura pelo id
    public Leitura retornaPorId(UUID id) {
        return leituraRepository.findById(id).get();
    }

    // Update
    public Leitura atualiza(UUID id, Leitura atualizaLeitura) {
        Leitura leitura = leituraRepository.findById(id).get();
        leitura.setLocalidade(atualizaLeitura.getLocalidade());
        leitura.setTemperatura(atualizaLeitura.getTemperatura());
        leitura.setUmidade(atualizaLeitura.getUmidade());
        leitura.setVento(atualizaLeitura.getVento());
        return leituraRepository.save(leitura);
    }

    // Delete (sem retornar objeto deletado)
    public void deletaPorId(UUID id) {
        leituraRepository.deleteById(id);
    }

    // Delete (retornando objeto deletado)
    public Leitura deleta(UUID id) {
        Leitura leitura = leituraRepository.findById(id).get();
        leituraRepository.delete(leitura);
        return leitura;
    }
}
