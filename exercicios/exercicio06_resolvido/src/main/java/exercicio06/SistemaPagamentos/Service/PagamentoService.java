package exercicio06.SistemaPagamentos.Service;
import exercicio06.SistemaPagamentos.Models.ContaModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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