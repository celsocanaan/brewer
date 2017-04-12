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

import com.algaworks.brewer.modelo.Cliente;
import com.algaworks.brewer.modelo.TipoPessoa;
import com.algaworks.brewer.repositorio.Cidades;
import com.algaworks.brewer.repositorio.Estados;
import com.algaworks.brewer.repositorio.TipoLogradouros;
import com.algaworks.brewer.servico.ServicoCadaCliente;

@Controller
public class ControladorCliente {

	@Autowired
    private TipoLogradouros tipoLogradouros;  //injetado do repositório 
    
	@Autowired
    private Cidades cidades;  //injetado do repositório 
    
	@Autowired
    private Estados estados;  //injetado do repositório 
    
    @Autowired
    private ServicoCadaCliente servicoCadaCliente;  //injetado do repositório 
    
	@RequestMapping("/cliente/novo") // busca método "novo". Este é por default o get
	public ModelAndView novo(Cliente cliente) {
		
		ModelAndView mv = new ModelAndView("cliente/CadaCliente"); //view HTML a renderizar
		
		//Passa um nome e um valor do objeto
		mv.addObject("tiposPessoa", TipoPessoa.values());
		mv.addObject("estados", estados.findAll());
		mv.addObject("cidades", cidades.findAll());
		mv.addObject("tipoLogradouros", tipoLogradouros.findAll());
		
		return mv;  //retorna o modelo e a view
	}

	// Especifica o método "post"
	@RequestMapping(value = "/cliente/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cliente cliente, BindingResult result, Model modelo, RedirectAttributes attributes) {
		if (result.hasErrors()) { // Verifica se objeto Cliente tem algum erro
		    return novo(cliente); // retorna os dados da cliente na página
		}

		
		// Salvar no banco de dados
		servicoCadaCliente.salvar(cliente);
		
		// Adiciona atributo 'mensagem' da página html
		attributes.addFlashAttribute("mensagem", "Cliente salva com sucesso");

		// Retorna a url para cadastrar nova cliente. Browser faz nova requisição
		return new ModelAndView("redirect:/cliente/novo");
	}
	
}
