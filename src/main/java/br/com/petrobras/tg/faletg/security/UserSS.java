package br.com.petrobras.tg.faletg.security;

import java.util.Collection;
import java.util.Set;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.petrobras.tg.faletg.domain.enums.Perfil;

public class UserSS implements UserDetails {
	
	private Integer id;
	private String chave;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;

	public UserSS() {
		
	}
	
	public UserSS(Integer id, String chave, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.chave = chave;
		this.senha = senha;
		this.authorities = perfis.stream().map(p -> 
			new SimpleGrantedAuthority(p.getDescricao())).collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return chave;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
