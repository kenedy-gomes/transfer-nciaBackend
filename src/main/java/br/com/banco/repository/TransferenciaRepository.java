package br.com.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.banco.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

}
