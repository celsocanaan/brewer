package com.algaworks.brewer.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.brewer.modelo.Cidade;

@Repository
public interface Cidades extends JpaRepository<Cidade, Long> {
	public List<Cidade> findByEstadoId(Long idEstado);
}
