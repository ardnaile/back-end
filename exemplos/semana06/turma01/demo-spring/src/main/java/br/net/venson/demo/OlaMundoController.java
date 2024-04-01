package br.net.venson.demo;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaMundoController {

    @GetMapping("/")
    public String raiz() {
        return "Raiz da aplicação";
    }

    @GetMapping("/olamundo")
    public String olaMundo() {
        return "Olá, Mundo!";
    }
}
