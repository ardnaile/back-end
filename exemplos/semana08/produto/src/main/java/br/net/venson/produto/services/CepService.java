package br.net.venson.produto.services;

import br.net.venson.produto.models.Endereco;

public interface CepService {
    public Endereco converteCep(String cep);
}
