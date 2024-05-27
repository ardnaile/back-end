package eliandracardoso.exercicio7.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TransacaoDto(
        @NotBlank
        String recebedor,
        @NotBlank
        String pagador,
        @NotNull
        double quantidade) {}
