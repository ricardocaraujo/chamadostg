package br.com.petrobras.tg.faletg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.petrobras.tg.faletg.domain.enums.TipoProblema;
import br.com.petrobras.tg.faletg.service.ChamadoService;

@Controller
public class ChamadoController {

	
	@Autowired
	private ChamadoService chamadoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String abreChamado(Model model) {
		model.addAttribute("problemas", TipoProblema.values());
		return "chamado";
	}
	
}
