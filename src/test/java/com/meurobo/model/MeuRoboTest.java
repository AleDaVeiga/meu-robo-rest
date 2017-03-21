package com.meurobo.model;

import static com.meurobo.model.MeuRobo.MOVIMENTAR;
import static com.meurobo.model.MeuRobo.ROTACIONAR_DIREITA;
import static com.meurobo.model.MeuRobo.ROTACIONAR_ESQUERDA;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.meurobo.exception.ComandoInvalidoException;
import com.meurobo.exception.LimiteTerrenoException;

public class MeuRoboTest {
	private MeuRobo robo;

	@Before
	public void setUp() {
		robo = new MeuRobo();
	}

	@Test
	public void deveRetornarPosicaoInicial() throws Exception {
		String movimento = "";

		String posicao = robo.movimentar(movimento);

		assertEquals("(0,0,N)", posicao);
	}

	@Test
	public void deveMovimentarUmaPosicao() throws Exception {
		String movimento = criaMovimentos(MOVIMENTAR);

		String posicao = robo.movimentar(movimento);

		assertEquals("(0,1,N)", posicao);
	}

	@Test
	public void deveVirarParaDireita() throws Exception {
		String movimento = criaMovimentos(ROTACIONAR_DIREITA);

		String posicao = robo.movimentar(movimento);

		assertEquals("(0,0,E)", posicao);
	}

	@Test
	public void deveVirarParaEsquerda() throws Exception {
		String movimento = criaMovimentos(ROTACIONAR_ESQUERDA);

		String posicao = robo.movimentar(movimento);

		assertEquals("(0,0,W)", posicao);
	}

	@Test
	public void deveMovimentarPosicoesDentroDoLimite() throws Exception {
		String movimento = criaMovimentos(MOVIMENTAR, MOVIMENTAR, MOVIMENTAR, MOVIMENTAR, MOVIMENTAR);

		String posicao = robo.movimentar(movimento);

		assertEquals("(0,5,N)", posicao);
	}

	@Test(expected = LimiteTerrenoException.class)
	public void naoDeveMovimentarPosicoesAlemDoLimite() throws Exception {
		String movimento = criaMovimentos(MOVIMENTAR, MOVIMENTAR, MOVIMENTAR, MOVIMENTAR, MOVIMENTAR, MOVIMENTAR);

		robo.movimentar(movimento);
	}

	@Test(expected = ComandoInvalidoException.class)
	public void naoDeveMovimentarComComandoInvalido() throws Exception {
		String movimento = criaMovimentos('A');

		robo.movimentar(movimento);
	}

	private String criaMovimentos(Character... movimentos) {
		StringBuilder retorno = new StringBuilder();
		for (Character movimento : movimentos) {
			retorno.append(movimento);
		}
		return retorno.toString();
	}
}
