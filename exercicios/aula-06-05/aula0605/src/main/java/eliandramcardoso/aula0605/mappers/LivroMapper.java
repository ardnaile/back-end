package eliandramcardoso.aula0605.mappers;

import eliandramcardoso.aula0605.dtos.LivroDto;
import eliandramcardoso.aula0605.models.Livro;

public class LivroMapper {
    public LivroDto toDto(Livro livro){
        return new LivroDto(
                livro.getTitulo(),
                livro.getAutor(),
                livro.getPaginas(),
                livro.getDt_lancamento()
        );
    }

    public Livro toEntity(LivroDto livroDto){
        return new Livro(
                livroDto.titulo(),
                "",
                livroDto.paginas(),
                livroDto.dt_lancamento(),
                null // depois vamos tratar melhor
        );
    }
}
