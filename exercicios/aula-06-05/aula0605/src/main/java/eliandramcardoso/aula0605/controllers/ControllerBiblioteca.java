package eliandramcardoso.aula0605.controllers;

import eliandramcardoso.aula0605.models.Livro;
import eliandramcardoso.aula0605.services.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@RequestMapping("/")
public class ControllerBiblioteca {
    @Autowired
    BibliotecaService bibliotecaService;

    @GetMapping("/livros")
    public ResponseEntity<Object> getLivros(){
        ArrayList<Livro> listaLivros = bibliotecaService.getListaLivros();
        return ResponseEntity.status(200).body(listaLivros);
    }

    @PostMapping("/livros")
    public ResponseEntity<Object> criarLivro(){
        return null;
    }
}
