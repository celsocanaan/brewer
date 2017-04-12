package com.algaworks.brewer.controle;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.modelo.Usuario;

@Controller
public class ControladorUsuario {

	// @RequestMapping("/usuario/novo") //busca método "novo"
	// public String novo() {
	// return "usuario/CadaUsuario";
	// }

	@RequestMapping("/usuario/novo") // busca método "novo". Este é por default o get
	public String novo(Usuario usuario) {
		return "usuario/CadaUsuario";
	}

	// Especifica o método "post"
	@RequestMapping(value = "/usuario/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Usuario usuario, BindingResult result, Model modelo, RedirectAttributes attributes) {

		if (result.hasErrors()) { // Verifica se objeto Usuario tem algum erro
			return novo(usuario); // retorna dados da Usuario na página
		}

		// Salvar no banco de dados...
		// Passa mensagem para página html
		attributes.addFlashAttribute("mensagem", "Usuario salvo com sucesso");

		// Retorna a url para cadastrar nova Usuario. Browser faz nova requisição
		return "redirect:/usuario/novo";
	}
	
}
