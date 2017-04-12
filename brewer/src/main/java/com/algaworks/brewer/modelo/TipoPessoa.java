package com.algaworks.brewer.modelo;

public enum TipoPessoa {
	
	FISICA("Física"),       //0
	JURIDICA("Jurídica"),   //1
	OUTRA("Outra");         //2
	
	private String descricao;
	
	//Construtor da classe
	TipoPessoa(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
