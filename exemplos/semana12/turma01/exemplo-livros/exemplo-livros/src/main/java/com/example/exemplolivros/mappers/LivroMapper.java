package com.example.exemplolivros.mappers;

import com.example.exemplolivros.dtos.LivroDto;
import com.example.exemplolivros.models.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {
    public LivroDto toDto(Livro livro) {
        return new LivroDto(
                livro.getTitulo(),
                livro.getAutor().getNome(),
                livro.getPaginas(),
                livro.getDataLancamento()
        );
    }

    public Livro toEntity(LivroDto livroDto) {
        return new Livro(
                livroDto.titulo(),
                "",
                livroDto.paginas(),
                livroDto.dataLancamento(),
                null
        );
    }
}
