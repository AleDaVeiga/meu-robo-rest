package com.meurobo.model;

import static com.meurobo.model.Terreno.novoTerrenoPadrao;

import com.meurobo.exception.ComandoInvalidoException;

public class MeuRobo {
	public static Character MOVIMENTAR = 'M';
	public static Character ROTACIONAR_DIREITA = 'R';
	public static Character ROTACIONAR_ESQUERDA = 'L';

	public String movimentar(String movimento) {
		char[] movimentos = movimento.toCharArray();
		
		Terreno posicao = novoTerrenoPadrao();
		for (char comando : movimentos) {
			if(MOVIMENTAR.equals(comando)) {
				posicao.andar();
			} else if(ROTACIONAR_DIREITA.equals(comando)) {
				posicao.virarDireita();
			} else if(ROTACIONAR_ESQUERDA.equals(comando)) {
				posicao.virarEsquerda();
			} else {
				throw new ComandoInvalidoException();
			}
		}
		return posicao.toString();
	}
}
