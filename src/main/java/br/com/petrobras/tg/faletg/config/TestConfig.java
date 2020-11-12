package br.com.petrobras.tg.faletg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.petrobras.tg.faletg.service.EmailService;
import br.com.petrobras.tg.faletg.service.MockEmailService;

@Profile("test")
@Configuration
public class TestConfig {
	
	@Bean
	public MockEmailService mockEmailService() {
		return new MockEmailService();
	}
}
