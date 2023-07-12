package br.com.banco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import br.com.banco.model.Conta;
import br.com.banco.repository.ContaRepository;

@Service
public class ContaService  {

	@Autowired
	private ContaRepository contaRepository;
	
	  /*Listar todas as Contas*/
	 public List<Conta> listarContas() {
	        return contaRepository.findAll();
	    }
	 
	  /*Listar por Id*/
	 public Optional<Conta> buscarContaPorId(Long id) {
	        return contaRepository.findById(id);
	    }
	 
	  /*Criar Conta*/
	 public Conta criarConta(Conta conta) {
	        return contaRepository.save(conta);
	    }
	 
	  /*Atualizar Conta*/
	 public Conta atualizarConta(Conta conta) {
	        return contaRepository.save(conta);
	    }
	 
	  /*Deletar Conta*/
	 public void deletarConta(Long id) {
	        contaRepository.deleteById(id);
	    }
	 
}
