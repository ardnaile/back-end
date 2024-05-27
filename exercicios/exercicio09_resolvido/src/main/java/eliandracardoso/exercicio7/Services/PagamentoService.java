package eliandracardoso.exercicio7.Services;

import eliandracardoso.exercicio7.Models.Cliente;
import eliandracardoso.exercicio7.Models.Transacao;
import eliandracardoso.exercicio7.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eliandracardoso.exercicio7.Mappers.ClienteMapper;

import java.util.HashMap;
import java.util.Map;

@Service
public class PagamentoService {
    // injetando o repositório no service
    @Autowired
    ClienteRepository clienteRepository;

    // declarando o hashmap
    private final Map<String, Cliente> clientes;

    public PagamentoService(){

        // inicializando dois clientes
        this.clientes = new HashMap<>();
        clientes.put("Joao", new Cliente("Joao", 100.0, "senha123"));
        clientes.put("Maria", new Cliente("Maria", 200.0, "senha456"));
    }

    // retornando o cliente pelo nome, é transformado em dto no controller (essa é a melhor forma de fazer?)
    public Cliente retornaClientePeloNome(String nome){
        return clientes.get(nome);
    }

    // criando a transação
    public void realizarTransacao(Transacao transacao) {
        String pagadorNome = transacao.getPagador();
        String recebedorNome = transacao.getRecebedor();
        double quantidade = transacao.getQuantidade();

        Cliente pagador = clientes.get(pagadorNome);
        Cliente recebedor = clientes.get(recebedorNome);

        if (pagador != null && recebedor != null && pagador.getSaldo() >= quantidade){
            pagador.setSaldo(pagador.getSaldo() - quantidade);
            recebedor.setSaldo(recebedor.getSaldo() + quantidade);
        } else {
            throw new IllegalArgumentException("Pagador ou recebedor não encontrado ou saldo insuficiente");
        }
    }
}
