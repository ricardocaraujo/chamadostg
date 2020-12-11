package br.com.petrobras.tg.faletg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.petrobras.tg.faletg.domain.Empregado;

@Controller
public class LoginController {

	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String telaLogin() {
		return "login";
	}
	
	
	
	
}
