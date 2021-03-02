package br.com.petrobras.tg.faletg.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.petrobras.tg.faletg.domain.Chamado;
import br.com.petrobras.tg.faletg.repo.ChamadoRespository;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRespository chamadoRepository;
	
	@Autowired
	private EmailService emailService;
	
	public void save(Chamado chamado) {
		this.chamadoRepository.save(chamado);
		emailService.sendOrderConfirmationEmail(chamado);
	}
	
	public List<Chamado> findAll() {
		return this.chamadoRepository.findAll();
	}
	
	public String save(String baseFolder, String fileName, MultipartFile file) throws IOException {
		Path uploadPath = Paths.get(baseFolder); 
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		InputStream is = file.getInputStream();
		Path filePath = uploadPath.resolve(fileName);
		Files.copy(is, filePath, StandardCopyOption.REPLACE_EXISTING);
		return filePath.toString();
	}

	public void deleta(Integer id) {
		chamadoRepository.deleteById(id);		
	}

	public Chamado find(Integer id) {
		return chamadoRepository.getOne(id);
	}
	
}
