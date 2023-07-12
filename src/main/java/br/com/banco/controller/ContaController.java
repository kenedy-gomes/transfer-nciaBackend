package br.com.banco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.Conta;
import br.com.banco.services.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	private ContaService contaService;
	
	  /*Listar todas as Contas*/
	  @GetMapping
	    public ResponseEntity<List<Conta>> listarContas() {
	        List<Conta> contas = contaService.listarContas();
	        return ResponseEntity.ok(contas);
	    }
	
	  /*Listar por Id*/
	  @GetMapping("/{id}")
	    public ResponseEntity<Conta> buscarContaPorId(@PathVariable Long id) {
	        Optional<Conta> conta = contaService.buscarContaPorId(id);
	        return conta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }
	  
	  @PostMapping
	    public ResponseEntity<Conta> criarConta(@RequestBody Conta conta) {
	        Conta novaConta = contaService.criarConta(conta);
	        return ResponseEntity.status(HttpStatus.CREATED).body(novaConta);
	    }
	  
	  @PutMapping("/{id}")
	    public ResponseEntity<Conta> atualizarConta(@PathVariable Long id, @RequestBody Conta conta) {
	        Optional<Conta> contaExistente = contaService.buscarContaPorId(id);

	        if (contaExistente.isPresent()) {
	            conta.getId_conta();
	            Conta contaAtualizada = contaService.atualizarConta(conta);
	            return ResponseEntity.ok(contaAtualizada);
	        }

	        return ResponseEntity.notFound().build();
	    }
	  
	  @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletarConta(@PathVariable Long id) {
	        Optional<Conta> conta = contaService.buscarContaPorId(id);

	        if (conta.isPresent()) {
	            contaService.deletarConta(id);
	            return ResponseEntity.noContent().build();
	        }

	        return ResponseEntity.notFound().build();
	    }
	  
}
