package com.example.exemploTransacao.services;

import com.example.exemploTransacao.dtos.TransacaoDto;
import com.example.exemploTransacao.mappers.TransacaoMapper;
import com.example.exemploTransacao.models.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {
    @Autowired
    TransacaoMapper transacaoMapper;

    public TransacaoDto getTransacao() {
        Transacao transacao = new Transacao(
                "satc",
                "ramon",
                100.0,
                true
        );
        return transacaoMapper.toDto(transacao);
    }
}
