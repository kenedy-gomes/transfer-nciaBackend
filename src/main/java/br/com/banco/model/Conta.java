package br.com.banco.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_conta;
	private String nome_responsavel;
	
	public Conta() {}
	
	public Conta(Long id_conta, String nome_responsavel) {
		this.id_conta = id_conta;
		this.nome_responsavel = nome_responsavel;
	}
	public Long getId_conta() {
		return id_conta;
	}
	public void setId_conta(Long id_conta) {
		this.id_conta = id_conta;
	}
	public String getNome_responsavel() {
		return nome_responsavel;
	}
	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel = nome_responsavel;
	}
 
}
