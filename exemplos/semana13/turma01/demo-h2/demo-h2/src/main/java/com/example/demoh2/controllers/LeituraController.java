package com.example.demoh2.controllers;

import com.example.demoh2.models.Leitura;
import com.example.demoh2.services.LeituraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class LeituraController {
    @Autowired
    private LeituraService leituraService;

    @GetMapping
    public List<Leitura> retornaTudo() {
        return leituraService.retornaTudo();
    }

    @PostMapping
    public Leitura salvar(@RequestBody Leitura leitura) {
        return leituraService.salva(leitura);
    }

    @GetMapping("/{id}")
    public Leitura retornaPorId(@PathVariable UUID id) {
        return leituraService.retornaPorId(id);
    }

    @PatchMapping("/{id}")
    public Leitura atualiza(@PathVariable UUID id, @RequestBody Leitura leitura) {
        return leituraService.atualiza(id, leitura);
    }

    @DeleteMapping("/{id}")
    public Leitura deleta(@PathVariable UUID id) {
        return leituraService.deleta(id);
    }
}
