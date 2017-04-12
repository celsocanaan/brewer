package com.algaworks.brewer.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.brewer.modelo.Cidade;
import com.algaworks.brewer.repositorio.Cidades;


@Controller
@RequestMapping("/cidades")
public class ControladorCidade {

	@Autowired
	private Cidades cidades;

	@RequestMapping("/nova")
	public String nova() {
		return "cidade/CadaCidade";
	}
	
	/**
	 * Quando content type é APPLICATION_JSON_VALUE é direcionado para este método
	 * É passado "-1" para retornar estado vazio.
	 * @param idEstado
	 * @return
	 */
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)  //Receberá cidades do controlador
	public @ResponseBody List<Cidade> pesquisarPorIdEstado(
			@RequestParam(name = "estado", defaultValue = "-1") Long idEstado) {
		
		System.out.println("ControladorCidade: Estado = "+ idEstado);
		
		return cidades.findByEstadoId(idEstado);
	}
}