package com.meurobo.model;

import com.meurobo.exception.LimiteTerrenoException;

public class Coordenada {
	private Integer coordenada;
	private Integer limiteCoordenada;

	public Coordenada(Integer limiteCoordenada) {
		this.coordenada = 0;
		this.limiteCoordenada = limiteCoordenada;
	}

	public Integer getCoordenada() {
		return this.coordenada;
	}

	public void andar() {
		if (this.coordenada < this.limiteCoordenada) {
			this.coordenada++;
		} else {
			throw new LimiteTerrenoException();
		}
	}

	public void voltar() {
		if (this.coordenada > 0) {
			this.coordenada--;
		} else {
			throw new LimiteTerrenoException();
		}
	}
}
