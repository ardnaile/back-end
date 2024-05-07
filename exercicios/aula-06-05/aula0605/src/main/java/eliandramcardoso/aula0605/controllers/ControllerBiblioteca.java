package eliandramcardoso.aula0605.controllers;

import eliandramcardoso.aula0605.dtos.LivroDto;
import eliandramcardoso.aula0605.models.Livro;
import eliandramcardoso.aula0605.services.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
public class ControllerBiblioteca {
    @Autowired
    BibliotecaService bibliotecaService;

    @GetMapping("/livros")
    public ResponseEntity<Object> getLivros(){
        List<LivroDto> listaLivros = bibliotecaService.getListaLivros();
        return ResponseEntity.status(200).body(listaLivros);
    }

    @PostMapping("/livros")
    public ResponseEntity<Object> criarLivro(@RequestBody LivroDto livroDto){
        LivroDto createdLivroDto = bibliotecaService.saveLivro(livroDto);
        return ResponseEntity.status(201).body(createdLivroDto);
    }
}
