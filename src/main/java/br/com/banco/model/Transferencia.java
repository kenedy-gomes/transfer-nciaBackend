package br.com.banco.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date data_transferencia;
	private Double valor;
    private String tipo;
    private String nome_operador_transacao;

    public Transferencia() {}

	public Transferencia(Long id, Date data_transferencia, Double valor, String tipo, String nome_operador_transacao) {
		this.id = id;
		this.data_transferencia = data_transferencia;
		this.valor = valor;
		this.tipo = tipo;
		this.nome_operador_transacao = nome_operador_transacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData_transferencia() {
		return data_transferencia;
	}

	public void setData_transferencia(Date data_transferencia) {
		this.data_transferencia = data_transferencia;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome_operador_transacao() {
		return nome_operador_transacao;
	}

	public void setNome_operador_transacao(String nome_operador_transacao) {
		this.nome_operador_transacao = nome_operador_transacao;
	}
    
	 
}
