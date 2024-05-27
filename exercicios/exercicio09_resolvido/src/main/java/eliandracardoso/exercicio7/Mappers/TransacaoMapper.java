package eliandracardoso.exercicio7.Mappers;

import eliandracardoso.exercicio7.DTO.TransacaoDto;
import eliandracardoso.exercicio7.Models.Transacao;

public class TransacaoMapper {
    public TransacaoDto toDto(Transacao transacao){
        TransacaoDto dto = new TransacaoDto(
                transacao.getRecebedor(),
                transacao.getPagador(),
                transacao.getQuantidade()
        );
        return dto;
    }
    public Transacao toEntity(TransacaoDto transacaoDto){
        Transacao objeto = new Transacao(
                transacaoDto.recebedor(),
                transacaoDto.pagador(),
                transacaoDto.quantidade()
        );
        return objeto;
    }
}
