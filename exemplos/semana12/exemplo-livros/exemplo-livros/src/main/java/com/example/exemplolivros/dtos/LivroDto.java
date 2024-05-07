package com.example.exemplolivros.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.util.Date;

public record LivroDto(
        @NotBlank( message = "Precisa de um titulo")
        String titulo,
        @NotBlank( message = "Precisa de um autor")
        String autor,
        @NotNull
        @Positive(message = "As paginas precisam ser um numero positivo")
        Integer paginas,
        @NotNull
        @PastOrPresent(message = "A data de lancamento precisa estar no passado")
        Date dataLancamento
) {
}
