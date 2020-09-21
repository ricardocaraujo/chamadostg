package br.com.petrobras.tg.faletg.domain.enums;

public enum Situacao {
	
	ABERTO(1, "Aberto"),
	EM_EXECUÇÃO(2, "Em execução"),
	CONCLUÍDO(3, "Concluído");
	
	private int id;
	private String descricao;
	
	private Situacao (int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
