package eliandracardoso.exercicio7.Controller;

import eliandracardoso.exercicio7.DTO.ClienteDto;
import eliandracardoso.exercicio7.DTO.TransacaoDto;
import eliandracardoso.exercicio7.Mappers.ClienteMapper;
import eliandracardoso.exercicio7.Mappers.TransacaoMapper;
import eliandracardoso.exercicio7.Models.Cliente;
import eliandracardoso.exercicio7.Models.Transacao;
import eliandracardoso.exercicio7.Services.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
public class PagamentosController {

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private TransacaoMapper transacaoMapper;

    @GetMapping("/cliente/{nome}")
    public ResponseEntity<ClienteDto> retornarCliente(@PathVariable String nome){
        Cliente cliente = pagamentoService.retornaClientePeloNome(nome);
        if (cliente != null){
            ClienteDto clienteDto = clienteMapper.toDto(cliente);
            return ResponseEntity.ok(clienteDto);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/transacao")
    public ResponseEntity<TransacaoDto> realizarTransacao(@RequestBody @Valid TransacaoDto transacaoDto){
        Transacao transacao = transacaoMapper.toEntity(transacaoDto);
        pagamentoService.realizarTransacao(transacao);
        return ResponseEntity.ok(transacaoDto);
    }
}
