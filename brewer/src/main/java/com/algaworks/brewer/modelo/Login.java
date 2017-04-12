package com.algaworks.brewer.modelo;

import java.io.Serializable;

public class Login implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private Long id;
    private String nomeLogin;
	
    //Construtor default é obrigatório para exibição correta pelo framework 
	public Login() {   
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeLogin() {
		return nomeLogin;
	}

	public void setNomeLogin(String nomeLogin) {
		this.nomeLogin = nomeLogin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
		
}
