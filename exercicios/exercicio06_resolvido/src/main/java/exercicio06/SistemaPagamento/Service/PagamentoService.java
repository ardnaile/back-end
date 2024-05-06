package exercicio06.SistemaPagamento.Service;

import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    public Object atualizarSaldos ( String conta_id, Double saldo) throws Exception {
    /*
    RestTemplate restTemplate = new RestTemplate();

    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    restTemplate = restTemplateBuilder.build();

    ContaModel atualizarSaldo = new ContaModel();
        atualizarSaldo.setConta_id(conta_id);
        atualizarSaldo.setSaldo(saldo);



    ContaModel saldoAtualizado = restTemplate.postForObject("http://localhost:8080/atualizar-saldo/", atualizarSaldo, ContaModel.class);

        */
        return null;
    }

}