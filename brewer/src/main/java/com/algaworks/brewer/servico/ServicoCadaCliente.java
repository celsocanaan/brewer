package com.algaworks.brewer.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.brewer.modelo.Cliente;
import com.algaworks.brewer.repositorio.Clientes;

/**
 * Responsável pelos servicos relacionado à classe Cliente
 * Deve-se registrar em Appinitializer e lá criar a classe ServiceConfig
 */
@Service
public class ServicoCadaCliente {
	
	@Autowired
	private Clientes pessoas;  //Repositório de pessoa
	
	@Transactional     //Abre uma transação quando inicia médoto salvar
	public void salvar(Cliente pessoa) {
		pessoas.save(pessoa);
	}
	

}
