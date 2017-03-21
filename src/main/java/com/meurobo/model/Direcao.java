package com.meurobo.model;

public class Direcao {
	public static final String NORTE = "N";
	public static final String SUL = "S";
	public static final String LESTE = "E";
	public static final String OESTE = "W";

	private String valor;

	public static Direcao novaDirecaoPadrao() {
		return new Direcao(NORTE);
	}

	private Direcao(String valor) {
		this.valor = valor;
	}

	public boolean isNorte() {
		return NORTE.equals(valor);
	}

	public boolean isLeste() {
		return LESTE.equals(valor);
	}

	public boolean isSul() {
		return SUL.equals(valor);
	}

	public boolean isOeste() {
		return OESTE.equals(valor);
	}

	@Override
	public String toString() {
		return new String(valor);
	}

	public void virarDireita() {
		if (isNorte()) {
			this.valor = LESTE;
		} else if (isLeste()) {
			this.valor = SUL;
		} else if (isSul()) {
			this.valor = OESTE;
		} else {
			this.valor = NORTE;
		}
	}

	public void virarEsquerda() {
		if (isNorte()) {
			this.valor = OESTE;
		} else if (isOeste()) {
			this.valor = SUL;
		} else if (isSul()) {
			this.valor = LESTE;
		} else {
			this.valor = NORTE;
		}
	}
}