package com.meurobo.model;

import static com.meurobo.model.Direcao.novaDirecaoPadrao;

public class Terreno {
	private Coordenada coordenadaX;
	private Coordenada coordenadaY;
	private Direcao direcao;

	public static Terreno novoTerrenoPadrao() {
		return new Terreno(5, 5);
	}

	public Terreno(Integer limiteCoordenadaX, Integer limiteCoordenadaY) {
		this.coordenadaX = new Coordenada(limiteCoordenadaX);
		this.coordenadaY = new Coordenada(limiteCoordenadaY);
		this.direcao = novaDirecaoPadrao();
	}

	public Integer getCoordenadaX() {
		return this.coordenadaX.getCoordenada();
	}

	public Integer getCoordenadaY() {
		return this.coordenadaY.getCoordenada();
	}

	public String getDirecao() {
		return this.direcao.toString();
	}

	@Override
	public String toString() {
		StringBuilder atual = new StringBuilder();
		atual.append("(").append(getCoordenadaX());
		atual.append(",").append(getCoordenadaY());
		atual.append(",").append(getDirecao()).append(")");
		return atual.toString();
	}

	public void andar() {
		if (direcao.isNorte()) {
			this.coordenadaY.andar();
		} else if (direcao.isLeste()) {
			this.coordenadaX.andar();
		} else if (direcao.isSul()) {
			this.coordenadaY.voltar();
		} else if (direcao.isOeste()) {
			this.coordenadaX.voltar();
		}
	}

	public void virarDireita() {
		this.direcao.virarDireita();
	}

	public void virarEsquerda() {
		this.direcao.virarEsquerda();
	}
}
