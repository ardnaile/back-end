package com.example.exemplocrud.dtos;

import java.time.Instant;

public record ApiExceptionDto(
        String titulo,
        String descricao,
        Instant data
) {
}
