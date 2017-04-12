package com.algaworks.brewer.controle;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.modelo.TipoLogradouro;
import com.algaworks.brewer.servico.ServicoCadaTipoLogradouro;

@Controller
public class ControladorTipoLogradouro {
	
	@Autowired
    private ServicoCadaTipoLogradouro servicoCadaTipoLogradouro;  //injetado do repositório 
	
	@RequestMapping("/cidade/tipoLogradouro")
	public ModelAndView novo() {
		
		ModelAndView mv = new ModelAndView("cidade/CadaTipoLogradouro"); //view HTML a renderizar
		return mv;  //retorna o modelo e a view
	}
	
	// Especifica o método "post"
	@RequestMapping(value = "/tipoLogradouro/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid TipoLogradouro tipoLogradouro, BindingResult result, Model modelo, RedirectAttributes attributes) {
		/*
		if (result.hasErrors()) { 
			return new ModelAndView("cidade/CadaTipoLogradouro"); 
		}
		*/
		
		// Salvar no banco de dados
		servicoCadaTipoLogradouro.salvar(tipoLogradouro);
		
		// Adiciona atributo 'mensagem' da página html
		attributes.addFlashAttribute("mensagem", "Tipo de Logradouro salvo com sucesso");

		// Retorna a url para cadastrar nova pessoa. Browser faz nova requisição
		return new ModelAndView("redirect:/tipoLogradouro/novo");
	}
	
	
	
}
