package br.com.petrobras.tg.faletg.domain.enums;

public enum TipoProblema {

	FUNCAO(1, "Função"),
	V3O2(2, "V3O2"),
	WEBSINTESI(3, "WebSintesi");
	
	private int id;
	private String descricao;
	
	private TipoProblema (int id, String descricao) {
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
