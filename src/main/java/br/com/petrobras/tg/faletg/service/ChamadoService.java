package br.com.petrobras.tg.faletg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petrobras.tg.faletg.domain.Chamado;
import br.com.petrobras.tg.faletg.repo.ChamadoRespository;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRespository chamadoRepository;
	
	public void save(Chamado chamado) {
		chamadoRepository.save(chamado);
	}
	
}
