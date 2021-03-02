package br.com.petrobras.tg.faletg.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import br.com.petrobras.tg.faletg.domain.Chamado;
import br.com.petrobras.tg.faletg.domain.enums.TipoProblema;
import br.com.petrobras.tg.faletg.service.ChamadoService;
import br.com.petrobras.tg.faletg.service.FileUploadService;

@Controller
public class ChamadoController {

	
	@Autowired
	private ChamadoService chamadoService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	/*
	 * @Autowired private SalvaAnexoService salvaAnexoService;
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String preparaChamado(Model model) {
		Chamado chamado = new Chamado();
		model.addAttribute("chamado", chamado);
		model.addAttribute("problemas", TipoProblema.values());
		return "chamado";
	}
	
	@RequestMapping(value="registra", method=RequestMethod.POST)
	public String registraChamado(@ModelAttribute Chamado chamado, 
			@RequestParam("files") MultipartFile[] files, Model model) throws IOException{
		
		/*
		 * List<String> anexos = Arrays.asList(files).stream(). map(file ->
		 * fileUploadUtil.save("anexos", file.getName(),
		 * file)).collect(Collectors.toList());
		 */	
		List<String> anexos = new ArrayList<>(); 
		for(MultipartFile file:files) { 
			anexos.add(fileUploadService.save("anexos", file));
		}		 
		chamado.setAnexo(anexos);
		this.chamadoService.save(chamado);
		return "redirect:lista";
	}
	
	@RequestMapping(value="lista", method=RequestMethod.GET)
	public String listaChamados(Model model) {
		List<Chamado> chamados = chamadoService.findAll();
		model.addAttribute("chamados", chamados);
		return "lista";
	}
	
	@RequestMapping(value="/deleta/{id}", method = RequestMethod.DELETE)
	public String deletaChamado(@PathVariable(name="id") Integer id) {
		chamadoService.deleta(id);
		return "redirect:/lista";
	}
	
	@RequestMapping(value="/atualiza/{id}", method = RequestMethod.GET)
	public String atualizaChamado(@PathVariable(name="id") Integer id, Model model) {
		Chamado chamado = chamadoService.find(id);
		model.addAttribute("chamado", chamado);
		return "chamado";
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Falha ao carregar arquivo")
	@ExceptionHandler(IOException.class)
	public void erroAnexo() {
		
	}
	
	
}
