package com.example.exemploTransacao.controllers;

import com.example.exemploTransacao.dtos.TransacaoDto;
import com.example.exemploTransacao.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacaoController {
    @Autowired
    TransacaoService transacaoService;

    @GetMapping("/transacao")
    public ResponseEntity<Object> getTransacao() {
        TransacaoDto transacaoDto = transacaoService.getTransacao();
        return ResponseEntity.status(HttpStatus.OK).body(transacaoDto);
    }
}
