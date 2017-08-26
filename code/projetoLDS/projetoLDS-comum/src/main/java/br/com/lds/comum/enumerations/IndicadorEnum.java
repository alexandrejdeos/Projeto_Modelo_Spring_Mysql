package br.com.lds.comum.enumerations;

public enum IndicadorEnum {
	N(0, "nao"), S(1, "sim");

	private Integer valor;
	private String chave;

	IndicadorEnum(Integer valor, String chave) {
		this.chave = chave;
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}

	public String getChave() {
		return chave;
	}

	public boolean getBooleanValue() {
		return this == S;
	}

	public static IndicadorEnum[] getSortedValues() {
		return new IndicadorEnum[] { S, N };
	}
	
	
}
