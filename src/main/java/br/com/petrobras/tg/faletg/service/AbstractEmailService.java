package br.com.petrobras.tg.faletg.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import br.com.petrobras.tg.faletg.domain.Chamado;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.recipient}")
	private String recipient;
	
	@Value("${default.sender}")
	private String sender;

	@Override
	public void sendOrderConfirmationEmail(Chamado chamado) {
		SimpleMailMessage smm = prepareSimpleMailMessageFromChamado(chamado);
		sendEmail(smm);
	}

	
	protected SimpleMailMessage prepareSimpleMailMessageFromChamado(Chamado chamado) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo(sender);
		smm.setTo(recipient);
		smm.setSubject("Nova solilicitação");
		smm.setSentDate(new Date(System.currentTimeMillis()));
		smm.setText(chamado.toString());
		return smm;
	}
	
	
}
