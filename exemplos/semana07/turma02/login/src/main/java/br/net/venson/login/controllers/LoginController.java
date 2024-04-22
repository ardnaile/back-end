package br.net.venson.login.controllers;

import br.net.venson.login.models.Credencial;
import br.net.venson.login.models.Pessoa;
import br.net.venson.login.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @Value("${app.codigo}")
    private String codigo;

    @GetMapping("/codigo")
    public ResponseEntity<Object> codigo() {
        return ResponseEntity.status(200).body(this.codigo);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Credencial credencial) {
        Boolean estaLogado = loginService.checarCredencial(credencial.getUsuario(), credencial.getSenha());
        if (estaLogado) {
            Pessoa pessoa = loginService.retornaPessoa(credencial.getUsuario());
            return ResponseEntity.status(200).body(pessoa);
        }
        return ResponseEntity.status(401).body("Erro ao realizar o login");
    }
}
