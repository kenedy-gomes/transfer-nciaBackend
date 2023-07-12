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
import br.com.banco.model.Transferencia;
import br.com.banco.services.TransferenciaService;


@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {
	
	
	@Autowired
	private TransferenciaService transferenciaService;
		
	 /*Listar todas as Contas*/
	  @GetMapping
	    public ResponseEntity<List<Transferencia>> listarContas() {
	        List<Transferencia> transferencias = transferenciaService.listarContas();
	        return ResponseEntity.ok(transferencias);
	    }
	
	  /*Listar por Id*/
	  @GetMapping("/{id}")
	    public ResponseEntity<Transferencia> buscarContaPorId(@PathVariable Long id) {
	        Optional<Transferencia> transferencias = transferenciaService.buscarContaPorId(id);
	        return transferencias.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }
	  
	  @PostMapping
	    public ResponseEntity<Transferencia> criarConta(@RequestBody Transferencia transferencia) {
		  Transferencia novaConta = transferenciaService.criarConta(transferencia);
	        return ResponseEntity.status(HttpStatus.CREATED).body(novaConta);
	    }
	  
	  @PutMapping("/{id}")
	    public ResponseEntity<Transferencia> atualizarConta(@PathVariable Long id, @RequestBody Transferencia transferencia) {
	        Optional<Transferencia> contaExistente = transferenciaService.buscarContaPorId(id);

	        if (contaExistente.isPresent()) {
	        	transferencia.getId();
	        	Transferencia contaAtualizada = transferenciaService.atualizarConta(transferencia);
	            return ResponseEntity.ok(contaAtualizada);
	        }

	        return ResponseEntity.notFound().build();
	    }
	  
	  @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletarConta(@PathVariable Long id) {
	        Optional<Transferencia> transferencia = transferenciaService.buscarContaPorId(id);

	        if (transferencia.isPresent()) {
	        	transferenciaService.deletarConta(id);
	            return ResponseEntity.noContent().build();
	        }

	        return ResponseEntity.notFound().build();
	    }
	
	
}
