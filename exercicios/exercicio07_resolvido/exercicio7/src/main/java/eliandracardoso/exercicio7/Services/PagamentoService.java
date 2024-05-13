package eliandracardoso.exercicio7.Services;

import eliandracardoso.exercicio7.Models.Cliente;
import eliandracardoso.exercicio7.Models.Transacao;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PagamentoService {
    private final Map<String, Cliente> clientes;

    public PagamentoService(){
        this.clientes = new HashMap<>();
        clientes.put("Joao", new Cliente("Joao", 100.0, "senha123"));
        clientes.put("Maria", new Cliente("Maria", 200.0, "senha456"));
    }

    public Cliente retornaClientePeloNome(String nome){
        return clientes.get(nome);
    }

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
