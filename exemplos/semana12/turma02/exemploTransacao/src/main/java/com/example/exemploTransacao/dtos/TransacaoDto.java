package com.example.exemploTransacao.dtos;

public record TransacaoDto(
        String remetente,
        String destinatario,
        Double valor
) {
}
