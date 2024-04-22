package venson.exemploweb.services;

import org.springframework.stereotype.Service;
import venson.exemploweb.models.Usuario;

@Service
public class LoginServices {
    public Boolean checarCredencial(String nome, String senha) {
        return nome.equals("satc") && senha.equals("123456");
    }

    public Usuario retornaPessoa(String nome) {
        Usuario usuario = new Usuario(
                nome,
                20,
                "Este eh um usuario cadastrado!"
        );
        return usuario;
    }
}
