package br.net.venson.produto.services;

import br.net.venson.produto.models.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ViaCepService implements CepService {
    private RestClient client = RestClient.create("https://viacep.com.br/ws");

    @Override
    public Endereco converteCep(String cep) {
        return client
                .get()
                .uri("/{cep}/json/", cep)
                .retrieve()
                .body(Endereco.class);
    }
}
