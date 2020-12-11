package br.com.petrobras.tg.faletg.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.com.petrobras.tg.faletg.domain.enums.Situacao;
import br.com.petrobras.tg.faletg.domain.enums.TipoProblema;

@Entity
public class Chamado implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String titulo;
	
	private String descricao;
	
	private Situacao situacao;
	
	private TipoProblema tipoProblema;
	
	@DateTimeFormat(iso = ISO.DATE) // padrão ISO = aaaa-mm-dd
	private LocalDate dataAbertura;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataEncerramento;
	
	@ElementCollection
	private List<String> anexos;
	
	private Empregado usuario;
	
	private Empregado tecnico;
	
	public Chamado() {
		
	}

	public Chamado(Integer id, String titulo, String descricao, Situacao situacao, TipoProblema tipoProblema, LocalDate dataAbertura,
			LocalDate dataEncerramento, Empregado usuario, Empregado tecnico) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.situacao = situacao;
		this.tipoProblema = tipoProblema;
		this.dataAbertura = LocalDate.now();
		this.dataEncerramento = dataEncerramento;
		this.usuario = usuario;
		this.tecnico = tecnico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	public TipoProblema getTipoProblema() {
		return tipoProblema;
	}

	public void setTipoProblema(TipoProblema tipoProblema) {
		this.tipoProblema = tipoProblema;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDate getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(LocalDate dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public Empregado getUsuario() {
		return usuario;
	}

	public void setUsuario(Empregado usuario) {
		this.usuario = usuario;
	}

	public Empregado getTecnico() {
		return tecnico;
	}

	public void setTecnico(Empregado tecnico) {
		this.tecnico = tecnico;
	}
	
	public List<String> getAnexo() {
		return anexos;
	}

	public void setAnexo(List<String> anexos) {
		this.anexos = anexos;
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
		Chamado other = (Chamado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Título: ");
		sb.append(this.titulo);
		sb.append("Descrição: ");
		sb.append(this.descricao);
		sb.append("Empregado: ");
		//sb.append(this.usuario.getNome() + "(" + this.usuario.getChave() + ")");
		sb.append("Tipo problema: ");
		sb.append(this.tipoProblema.getDescricao());
		return sb.toString();
	}

}
