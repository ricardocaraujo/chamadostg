package br.com.petrobras.tg.faletg.service;

import org.springframework.mail.SimpleMailMessage;

import br.com.petrobras.tg.faletg.domain.Chamado;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Chamado chamado);
	
	void sendEmail(SimpleMailMessage msg);

}
