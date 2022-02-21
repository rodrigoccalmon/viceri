package com.viceri.backend.enums;

public enum Prioridade {
	ALTA(1, "Alta"),
	MEDIA(2, "Media"),
	BAIXA(3, "Baixa");
	
	private int cod;
	private String descricao;
	private Prioridade(int cod, String descricao) {
		this.cod  = cod;
		this.descricao = descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public static Prioridade toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(Prioridade x : Prioridade.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
