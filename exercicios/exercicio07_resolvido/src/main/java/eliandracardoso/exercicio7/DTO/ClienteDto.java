package eliandracardoso.exercicio7.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteDto(
        @NotBlank
        String nome,
        @NotNull
        double saldo) {}
