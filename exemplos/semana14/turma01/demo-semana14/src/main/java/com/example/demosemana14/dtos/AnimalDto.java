package com.example.demosemana14.dtos;

import java.util.UUID;

public record AnimalDto(
        UUID id,
        String nome,
        String tipo,
        Integer idade,
        Boolean ativo
) {
}
