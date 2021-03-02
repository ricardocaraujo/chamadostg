package br.com.petrobras.tg.faletg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.petrobras.tg.faletg.domain.Usuario;
import br.com.petrobras.tg.faletg.repo.UsuarioRepository;
import br.com.petrobras.tg.faletg.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String chave) throws UsernameNotFoundException {
		Usuario usuario = repo.findByChave(chave);
		if(usuario == null) {
			throw new UsernameNotFoundException(chave);
		} 
		return new UserSS(usuario.getId(), usuario.getChave(), usuario.getSenha(), usuario.getPerfis());
	}

}
