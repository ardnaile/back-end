package com.example.exemploTransacao.mappers;

import com.example.exemploTransacao.dtos.TransacaoDto;
import com.example.exemploTransacao.models.Transacao;
import org.springframework.stereotype.Component;

@Component
public class TransacaoMapper {
    public TransacaoDto toDto(Transacao transacao) {
        TransacaoDto transacaoDto = new TransacaoDto(
                transacao.getRemetente(),
                transacao.getDestinatario(),
                transacao.getValor()
        );
        return transacaoDto;
    }
}
