package eliandramcardoso.aula0605.dtos;

import eliandramcardoso.aula0605.models.Autor;

import java.util.Date;

public record LivroDto(
        String titulo,
        Autor autor,
        Integer paginas,
        Date dt_lancamento
) {
}
