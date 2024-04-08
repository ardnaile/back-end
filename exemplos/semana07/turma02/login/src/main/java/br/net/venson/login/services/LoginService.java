package br.net.venson.login.services;

import br.net.venson.login.models.Pessoa;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public Boolean checarCredencial(String usuario, String senha) {
        return usuario.equals("satc") && senha.equals("123456");
    }

    public Pessoa retornaPessoa(String usuario) {
        Pessoa pessoa = new Pessoa(
                usuario,
                "Pessoa Física",
                (short) 90
        );
        return pessoa;
    }
}
