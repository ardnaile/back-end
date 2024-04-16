package venson.exemploweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import venson.exemploweb.models.Credenciais;
import venson.exemploweb.models.Usuario;
import venson.exemploweb.services.LoginServices;

@RestController
public class LoginController {
    @Autowired
    LoginServices loginServices;

    @PostMapping("/autenticar")
    public ResponseEntity<Object> login(@RequestBody Credenciais credenciais) {
        Boolean estaLogado = loginServices.checarCredencial(credenciais.getNome(), credenciais.getSenha());
        if (estaLogado) {
            Usuario usuario = loginServices.retornaPessoa(credenciais.getNome());
            return ResponseEntity.status(200).body(usuario);
        }
        return ResponseEntity.status(401).body("Não foi possível realizar o login");
    }
}
