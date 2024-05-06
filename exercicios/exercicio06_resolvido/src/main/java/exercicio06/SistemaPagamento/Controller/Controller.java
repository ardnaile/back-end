package exercicio06.SistemaPagamento.Controller;

import exercicio06.SistemaPagamento.Models.ContaModel;
import exercicio06.SistemaPagamento.Service.*;
import exercicio06.SistemaPagamento.Service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

;


@RestController
@RequestMapping("/")
public class Controller {
    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private  SaldoService saldoService;

    @Autowired
    //Mexer aqui
    private ContaService contaService;

    //Todas Contas
    @GetMapping("")
    public ResponseEntity<Object> verSaldo() throws Exception{
        return ResponseEntity.status(HttpStatus.valueOf(201)).body(null);
    };

    //Somente uma Conta
    @GetMapping("{id}")
    public ResponseEntity<Object> verSaldo(@PathVariable("id") String id ) throws Exception{
        return ResponseEntity.status(HttpStatus.valueOf(201)).body(null);
    };

    //Criar Conta
    @PostMapping("criar-conta/{id}")
    public ResponseEntity<Object> verSaldo(@RequestBody ContaModel contaModel) throws Exception{
        try {
            ContaModel criarConta = (ContaModel) contaService.novaConta(
                    contaModel.getId(),
                    contaModel.getCpf(),
                    contaModel.getSaldo()
            );
            return ResponseEntity.status(HttpStatus.valueOf(201))
                    .contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                    .body(criarConta);

        } catch (HttpClientErrorException.BadRequest e) {
            return ResponseEntity.status(HttpStatus.valueOf(400))
                    .body(null);
        }
    };

    //Atualizar Conta
    @PutMapping("/conta-up/{id}")
    public ResponseEntity<Object> updConta(@RequestBody ContaModel contaModel) throws Exception{
        try {
            ContaModel updConta = (ContaModel) contaService.atualizarConta(
                    contaModel.getId(),
                    contaModel.getCpf(),
                    contaModel.getSaldo()
            );
            return ResponseEntity.status(HttpStatus.valueOf(204))
                    .contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                    .body(null);

        } catch (HttpClientErrorException.BadRequest e) {
            return ResponseEntity.status(HttpStatus.valueOf(400))
                    .body(null);
        }
    }

    //Deletar conta
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteConta(@PathVariable("id") String id ) throws Exception{
        return ResponseEntity.status(HttpStatus.valueOf(204)).body(null);
    };


    @PostMapping("/transacoes")
    public ResponseEntity<Object> criarTransacao(@RequestBody Transacao transacao) { // depois será criado um model Transacao para esse objeto
        // lógica de criação de transação, etc.
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/transacoes")
    public ResponseEntity<List<Transacao>> visualizarTodasTransacoes() {
        // lógica para puxar a lista de transações, etc.
        return ResponseEntity.status(HttpStatus.OK).body(ListaTransacoes);
    }

    @GetMapping("/transacoes/{transacaoId}")
    public ResponseEntity<Transacao> visualizarTransacao(@PathVariable int transacaoId) {
        // lógica para puxar a transação,etc.
        return ResponseEntity.status(HttpStatus.OK).body(transacao);
    }

}