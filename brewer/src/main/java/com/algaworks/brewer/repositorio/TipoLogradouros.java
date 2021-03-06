package com.algaworks.brewer.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.brewer.modelo.TipoLogradouro;

@Repository
public interface TipoLogradouros extends JpaRepository<TipoLogradouro, Long> {

}
