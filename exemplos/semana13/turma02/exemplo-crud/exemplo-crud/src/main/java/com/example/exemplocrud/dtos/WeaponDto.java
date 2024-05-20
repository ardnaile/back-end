package com.example.exemplocrud.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record WeaponDto(
        UUID id,
        @NotBlank(message = "O nome não pode estar em branco")
        String nome,
        @NotBlank(message = "O tipo não pode estar em branco")
        String tipo,
        @Min(value = 0, message = "O dano precisa ser maior do que zero")
        @Max(value = 100, message = "O dano precisa ser menor do que cem")
        Integer dano
) {
}
