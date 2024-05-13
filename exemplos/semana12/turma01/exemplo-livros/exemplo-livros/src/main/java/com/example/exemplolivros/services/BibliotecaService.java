package com.example.exemplolivros.services;

import com.example.exemplolivros.dtos.LivroDto;
import com.example.exemplolivros.mappers.LivroMapper;
import com.example.exemplolivros.models.Autor;
import com.example.exemplolivros.models.Livro;
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

    private BibliotecaService() {
        Autor autor = new Autor("Machado de Assis", "brasileiro", new Date());
        Livro livro = new Livro("Dom Casmurro", "classico", 250, new Date(), autor);
        listaLivros.add(livro);
    }

    public List<LivroDto> getListaLivros() {
        List<LivroDto> listaDto = listaLivros.stream().map(livroMapper::toDto).toList();
        return listaDto;
    }

    public LivroDto saveLivro(LivroDto livroDto) {
        Livro livro = livroMapper.toEntity(livroDto);
        livro.setAutor(new Autor("Autor Padrao", "Sem nacionalidade", new Date()));
        listaLivros.add(livro);
        return livroMapper.toDto(livro);
    }
}
