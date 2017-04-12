package com.algaworks.brewer.controle;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.modelo.Login;

@Controller
public class ControladorLogin {

//    @Autowired
//    private Clientes pessoas;  //Coloca repositorio 
    
	@RequestMapping("/login") // busca método "novo". Este é por default o get
	public String autenticar(Login login) {
		return "login/Login";
	}

	// Especifica o método "post"
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String cadastrar(@Valid Login login, BindingResult result, Model modelo, RedirectAttributes attributes) {

		if (result.hasErrors()) { // Verifica se objeto Cliente tem algum erro
			return autenticar(login); // retorna dados na página
		}

		// Salvar no banco de dados...
		// Passa mensagem para página html
		attributes.addFlashAttribute("mensagem", "Cliente salva com sucesso");

		// Retorna a url para cadastrar nova pessoa. Browser faz nova requisição
		return "redirect:/login/autenticar";
	}
	
}
