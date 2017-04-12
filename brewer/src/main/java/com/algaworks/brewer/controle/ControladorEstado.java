package com.algaworks.brewer.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorEstado {

	@RequestMapping("/cidade/novo")
	public String novo() {
		return "cidade/CadaEstado";
	}
}
