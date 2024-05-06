package exercicio06.SistemaPagamento.Service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class ContaService {
    public Object novaConta(Integer id, String cpf, Double saldo) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        //ContaModel newConta = new ContaModel();
        //newConta.setId(id);
        //newConta.getCpf(cpf);
        //newConta.setSaldo(saldo);

        //ContaModel contaCriada = restTemplate.postForObject("http://localhost:8080/atualizar-saldo/", newConta, ContaModel.class);
        //return contaCriada;
        return null;
    }

    public Object atualizarConta(Integer id, String cpf, Double saldo) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        //ContaModel atlConta = new ContaModel();
        //atlConta.setId(id);
        //atlConta.getCpf(cpf);
        //atlConta.setSaldo(saldo);

        //ContaModel contaCriada = restTemplate.postForObject("http://localhost:8080/atualizar-saldo/", atlConta, ContaModel.class);
        //return contaCriada;
        return null;


    }
}

