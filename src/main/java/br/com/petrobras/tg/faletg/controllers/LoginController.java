package br.com.petrobras.tg.faletg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.petrobras.tg.faletg.domain.Empregado;

public class LoginController {
	
	@Autowired 
	public BCryptPasswordEncoder pe;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String telaLogin(Model model) {
		Empregado empregado = new Empregado();
		model.addAttribute("empregado", empregado);
		return "login";
	}
	
	
}
