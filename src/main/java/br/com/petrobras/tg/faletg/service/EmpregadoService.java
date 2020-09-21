package br.com.petrobras.tg.faletg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petrobras.tg.faletg.domain.Empregado;
import br.com.petrobras.tg.faletg.repo.EmpregadoRepository;

@Service
public class EmpregadoService {

	@Autowired
	private EmpregadoRepository empregadoRepository;
	
	public void save(Empregado empregado) {
		empregadoRepository.save(empregado);
	}
	
}
