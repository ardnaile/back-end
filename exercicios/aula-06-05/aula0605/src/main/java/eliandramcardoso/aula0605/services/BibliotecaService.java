package eliandramcardoso.aula0605.services;

import eliandramcardoso.aula0605.dtos.LivroDto;
import eliandramcardoso.aula0605.mappers.LivroMapper;
import eliandramcardoso.aula0605.models.Autor;
import eliandramcardoso.aula0605.models.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BibliotecaService {
    @Autowired
    private LivroMapper livroMapper;
    private ArrayList<Livro> listaLivros = new ArrayList<>();

    private BibliotecaService(){
        Autor autor = new Autor("Machado de Assis", new Date(), "brasileiro");
        Livro livro = new Livro("Dom Casmurro", "Romance", 250, new Date(), autor);
        listaLivros.add(livro);
    }

    public List<LivroDto> getListaLivros(){
        List<LivroDto> listaDto = listaLivros.stream().map((livro) -> {
            return livroMapper.toDto(livro);
        }).toList();
        return listaDto;
    }
    public Livro saveLivro(Livro livro){
        listaLivros.add(livro);
        return livro;
    }
}
