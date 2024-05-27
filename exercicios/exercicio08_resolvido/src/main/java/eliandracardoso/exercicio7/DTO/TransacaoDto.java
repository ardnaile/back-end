package eliandracardoso.exercicio7.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TransacaoDto(
        @NotNull(message="A transação deve ter um recebedor!")
        String recebedor,
        @NotNull(message="A transação deve ter um pagador!")
        String pagador,
        @Positive(message="O valor da transação deve ser maior que 0!")
        double quantidade) {}
