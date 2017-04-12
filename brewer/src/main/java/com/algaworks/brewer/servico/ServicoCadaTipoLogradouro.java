package com.algaworks.brewer.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.brewer.modelo.TipoLogradouro;
import com.algaworks.brewer.repositorio.TipoLogradouros;

/**
 * Responsável pelos servicos relacionado à classe TipoLogradouro
 * Deve-se registrar em Appinitializer e lá criar a classe ServiceConfig
 */
@Service
public class ServicoCadaTipoLogradouro {
	
	@Autowired
	private TipoLogradouros tipoLogradouros;  //Repositório de TipoLogradouro
	
	@Transactional     //Abre uma transação quando inicia médoto salvar
	public void salvar(TipoLogradouro tipoLogradouro) {
		tipoLogradouros.save(tipoLogradouro);
	}

}
