package br.net.venson.produto.controllers;

import br.net.venson.produto.models.Endereco;
import br.net.venson.produto.models.Postagem;
import br.net.venson.produto.models.Solicitacao;
import br.net.venson.produto.services.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PostagemController {
    @Autowired
    private CepService cepService;
    private ArrayList<Postagem> listaDePostagems = new ArrayList<>();

    @GetMapping("/postar")
    public ResponseEntity<Object> recupera() {
        return ResponseEntity.status(200).body(listaDePostagems);
    }

    @PostMapping("/postar")
    public ResponseEntity<Object> postar(@RequestBody Solicitacao solicitacao) {
        Endereco enderecoDestinatario = cepService.converteCep(solicitacao.getDestinatario());
        Endereco enderecoRemetente = cepService.converteCep(solicitacao.getRemetente());
        Postagem postagem = new Postagem(
                solicitacao.getProduto(),
                enderecoDestinatario,
                enderecoRemetente
        );
        listaDePostagems.add(postagem);
        return ResponseEntity.status(200).body(postagem);
    }
}
