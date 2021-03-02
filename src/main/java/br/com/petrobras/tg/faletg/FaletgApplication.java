package br.com.petrobras.tg.faletg;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.petrobras.tg.faletg.domain.Usuario;
import br.com.petrobras.tg.faletg.domain.enums.Perfil;
import br.com.petrobras.tg.faletg.repo.UsuarioRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UsuarioRepository.class)
public class FaletgApplication implements CommandLineRunner {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(FaletgApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario(null, "behx", passwordEncoder.encode("senha"), new HashSet<Perfil>(Arrays.asList(Perfil.ADMIN, Perfil.USUARIO)));
		
		usuarioRepository.save(usuario);
	}

}
