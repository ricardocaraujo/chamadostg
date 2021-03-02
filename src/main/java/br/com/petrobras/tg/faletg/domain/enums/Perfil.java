package br.com.petrobras.tg.faletg.domain.enums;

public enum Perfil {
	
	ADMIN(1, "ROLE_ADMIN"),
	TECNICO(2, "ROLE_TECNICO"),
	USUARIO(3, "ROLE_USUARIO");
	
	private int cod;
	private String descricao;
	
	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Perfil getPerfil(Integer cod) {
		for(Perfil perfil : Perfil.values()) {
			if(cod == perfil.cod) {
				return perfil;
			}
		}
		return null;
	}
	
}
