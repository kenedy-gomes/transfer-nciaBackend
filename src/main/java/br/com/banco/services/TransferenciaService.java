package br.com.banco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	public List<Transferencia> listarContas() {
        return transferenciaRepository.findAll();
    }
 
  /*Listar por Id*/
 public Optional<Transferencia> buscarContaPorId(Long id) {
        return transferenciaRepository.findById(id);
    }
 
  /*Criar Conta*/
 public Transferencia criarConta(Transferencia transferencia) {
        return transferenciaRepository.save(transferencia);
    }
 
  /*Atualizar Conta*/
 public Transferencia atualizarConta(Transferencia transferencia) {
        return transferenciaRepository.save(transferencia);
    }
 
  /*Deletar Conta*/
 public void deletarConta(Long id) {
	 transferenciaRepository.deleteById(id);
    }
 
	
}
