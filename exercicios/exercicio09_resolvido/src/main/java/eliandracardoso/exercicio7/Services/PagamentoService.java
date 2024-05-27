package eliandracardoso.exercicio7.Services;

import eliandracardoso.exercicio7.Models.Cliente;
import eliandracardoso.exercicio7.Models.Transacao;
import eliandracardoso.exercicio7.Repositories.ClienteRepository;
import eliandracardoso.exercicio7.Repositories.TransacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    ClienteRepository clienteRepository;
    TransacaoRepository transacaoRepository;

    public void realizarTransacao(Transacao transacao) {
        String pagadorNome = transacao.getPagador();
        String recebedorNome = transacao.getRecebedor();
        double quantidade = transacao.getQuantidade();

        Cliente pagador = clienteRepository.buscaPeloNome(pagadorNome);
        Cliente recebedor = clienteRepository.buscaPeloNome(recebedorNome);

        if (pagador.getSaldo() >= quantidade){
            pagador.setSaldo(pagador.getSaldo() - quantidade);
            recebedor.setSaldo(recebedor.getSaldo() + quantidade);

            clienteRepository.save(pagador);
            clienteRepository.save(recebedor);
            transacaoRepository.save(transacao);

        } else {
            throw new IllegalArgumentException("Pagador ou recebedor não encontrado ou saldo insuficiente");
        }
    }
    public Cliente salvarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente retornaClientePeloNome(String nomeCliente){
        return clienteRepository.buscaPeloNome(nomeCliente);
    }
}
