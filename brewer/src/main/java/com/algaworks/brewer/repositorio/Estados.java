package com.algaworks.brewer.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.brewer.modelo.Estado;

@Repository
public interface Estados extends JpaRepository<Estado, Long> {

}
