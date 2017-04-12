package com.algaworks.brewer.modelo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Usuario {
	
	
	@NotNull(message = "Informe o código")
	private Integer id;
	
	@NotEmpty(message = "Nome obrigatório") @Size(min = 1, max = 80, message = "Informe 1 a 80 caracteres")
    private String nome;
	
	@NotEmpty(message = "Senha obrigatória") @Size(min = 1, max = 80, message = "Informe 1 a 80 caracteres")
    private String senha;
	
	//Construtor default é obrigatório para exibição correta pelo framework 
	public Usuario() {   
		
	}
	
	public Integer getId() {
		return id;
	}
		
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
