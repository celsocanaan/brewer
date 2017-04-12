package com.algaworks.brewer.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.brewer.modelo.Cliente;

@Repository
public interface Clientes extends JpaRepository<Cliente, Long> {
	
}
