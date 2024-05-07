package com.example.exemplolivros.controllers;

import com.example.exemplolivros.dtos.LivroDto;
import com.example.exemplolivros.services.BibliotecaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BibliotecaController {
    @Autowired
    BibliotecaService bibliotecaService;

    @GetMapping("/livros")
    public ResponseEntity<Object> getLivros(){
        List<LivroDto> listaLivros = bibliotecaService.getListaLivros();
        return ResponseEntity.status(200).body(listaLivros);
    }

    @PostMapping("/livros")
    public ResponseEntity<Object> saveLivro(@RequestBody @Valid LivroDto livroDto) {
        LivroDto createdLivroDto = bibliotecaService.saveLivro(livroDto);
        return ResponseEntity.status(201).body(createdLivroDto);
    }
}
