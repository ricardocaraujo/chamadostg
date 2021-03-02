package br.com.petrobras.tg.faletg.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.petrobras.tg.faletg.domain.enums.Perfil;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String chave;
	
	private String senha;
	
	/*
	 * @Enumerated
	 * 
	 * @ElementCollection(fetch = FetchType.EAGER) private Set<Perfil> perfis = new
	 * HashSet<>();
	 */	
	
	@ElementCollection(fetch = FetchType.EAGER) 
	private Set<Integer> perfis = new HashSet<>();
	
	public Usuario() {
		
	}

	public Usuario(Integer id, String chave, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.chave = chave;
		this.senha = senha;
		this.perfis = perfis.stream().map(Perfil::getCod).collect(Collectors.toSet());
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(Perfil::getPerfil).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
