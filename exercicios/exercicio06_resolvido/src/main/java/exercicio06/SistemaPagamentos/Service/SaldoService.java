package exercicio06.SistemaPagamentos.Service;

import exercicio06.SistemaPagamentos.Models.ContaModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SaldoService {
    public Object mostraSaldo(String conta_id) {
        /*
        RestTemplate restTemplate = new RestTemplate();

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        ContaModel saldos = new ContaModel();
        saldos.setConta_id(conta_id);


        ContaModel saldoConta = restTemplate.postForObject("http://localhost:9000/listarprodutos/",saldos ,ContaModel.class);
        */
        return null;
    }

}
