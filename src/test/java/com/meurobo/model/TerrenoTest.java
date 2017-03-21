package com.meurobo.model;

import static com.meurobo.model.Direcao.LESTE;
import static com.meurobo.model.Direcao.NORTE;
import static com.meurobo.model.Direcao.OESTE;
import static com.meurobo.model.Direcao.SUL;
import static com.meurobo.model.Terreno.novoTerrenoPadrao;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.meurobo.exception.LimiteTerrenoException;

public class TerrenoTest {
	private Terreno terreno;

	@Before
	public void setUp() {
		posicionarNorte();
	}

	@Test
	public void deveRetornarPosicaoInicial() throws Exception {
		Terreno terreno = novoTerrenoPadrao();

		assertEquals(Integer.valueOf(0), terreno.getCoordenadaX());
		assertEquals(Integer.valueOf(0), terreno.getCoordenadaY());
		assertEquals(NORTE, terreno.getDirecao());
	}

	@Test
	public void deveConvertePosicaoParaString() throws Exception {
		Terreno terreno = novoTerrenoPadrao();

		assertEquals("(0,0,N)", terreno.toString());
	}

	@Test
	public void deveAndarUmaPosicao() throws Exception {
		terreno.andar();

		assertEquals(Integer.valueOf(0), terreno.getCoordenadaX());
		assertEquals(Integer.valueOf(1), terreno.getCoordenadaY());
	}

	@Test
	public void deveVirarParaDireita() throws Exception {
		terreno.virarDireita();

		assertEquals(LESTE, terreno.getDirecao());
	}

	@Test
	public void deveDirecionarParaLesteQuandoPosicaoIgualNorteEVirarDireita() throws Exception {
		posicionarNorte();

		terreno.virarDireita();

		assertEquals(LESTE, terreno.getDirecao());
	}

	@Test
	public void deveDirecionarParaSulQuandoPosicaoIgualLesteEVirarDireita() throws Exception {
		posicionarLeste();

		terreno.virarDireita();

		assertEquals(SUL, terreno.getDirecao());
	}

	@Test
	public void deveDirecionarParaOesteQuandoPosicaoIgualSulEVirarDireita() throws Exception {
		posicionarSul();

		terreno.virarDireita();

		assertEquals(OESTE, terreno.getDirecao());
	}

	@Test
	public void deveDirecionarParaNorteQuandoPosicaoIgualOesteEVirarDireita() throws Exception {
		posicionarOeste();

		terreno.virarDireita();

		assertEquals(NORTE, terreno.getDirecao());
	}

	@Test
	public void deveVirarParaEsquerda() throws Exception {
		posicionarLeste();

		terreno.virarEsquerda();

		assertEquals(NORTE, terreno.getDirecao());
	}

	@Test
	public void deveDirecionarParaOesteQuandoPosicaoIgualNorteEVirarEsquerda() throws Exception {
		posicionarNorte();

		terreno.virarEsquerda();

		assertEquals(OESTE, terreno.getDirecao());
	}

	@Test
	public void deveDirecionarParaSulQuandoPosicaoIgualOesteEVirarEsquerda() throws Exception {
		posicionarOeste();

		terreno.virarEsquerda();

		assertEquals(SUL, terreno.getDirecao());
	}

	@Test
	public void deveDirecionarParaLesteQuandoPosicaoIgualSulEVirarEsquerda() throws Exception {
		posicionarSul();

		terreno.virarEsquerda();

		assertEquals(LESTE, terreno.getDirecao());
	}

	@Test
	public void deveDirecionarParaNorteQuandoPosicaoIgualLesteEVirarEsquerda() throws Exception {
		posicionarLeste();

		terreno.virarEsquerda();

		assertEquals(NORTE, terreno.getDirecao());
	}

	@Test
	public void deveAndarUmaPosicaoQuandoDirecaoIgualLeste() throws Exception {
		terreno.virarDireita(); // Leste

		terreno.andar();

		assertEquals(Integer.valueOf(1), terreno.getCoordenadaX());
		assertEquals(Integer.valueOf(0), terreno.getCoordenadaY());
	}

	@Test
	public void deveAndarUmaPosicaoQuandoDirecaoIgualSul() throws Exception {
		andarPosicoes(3);
		terreno.virarDireita(); // Leste
		terreno.virarDireita(); // Sul
		terreno.andar();

		assertEquals(Integer.valueOf(0), terreno.getCoordenadaX());
		assertEquals(Integer.valueOf(2), terreno.getCoordenadaY());
	}

	@Test
	public void deveAndarUmaPosicaoQuandoDirecaoIgualOeste() throws Exception {
		terreno.virarDireita(); // Leste
		andarPosicoes(3);
		terreno.virarDireita(); // Sul
		terreno.virarDireita(); // Oeste

		terreno.andar();

		assertEquals(Integer.valueOf(2), terreno.getCoordenadaX());
		assertEquals(Integer.valueOf(0), terreno.getCoordenadaY());
	}

	@Test(expected = LimiteTerrenoException.class)
	public void naoDeveAndarParaNorteQuandoLimiteMaximoParaNorteForAtingido() throws Exception {
		terreno = new Terreno(5, 5);
		andarPosicoes(5);

		terreno.andar();
	}

	@Test(expected = LimiteTerrenoException.class)
	public void naoDeveAndarParaLesteQuandoLimiteMaximoParaLesteForAtingido() throws Exception {
		terreno = new Terreno(5, 5);
		terreno.virarDireita(); // Leste
		andarPosicoes(5);

		terreno.andar();
	}

	@Test(expected = LimiteTerrenoException.class)
	public void naoDeveAndarParaSulQuandoLimiteMinimoParaSulForAtingido() throws Exception {
		terreno = new Terreno(5, 5);
		terreno.virarDireita(); // Leste
		terreno.virarDireita(); // Sul

		terreno.andar();
	}

	@Test(expected = LimiteTerrenoException.class)
	public void naoDeveAndarParaOesteQuandoLimiteMinimoParaOesteForAtingido() throws Exception {
		terreno = new Terreno(5, 5);
		terreno.virarEsquerda(); // Oeste

		terreno.andar();
	}
	
	@Test
	public void deveAndarUmaPosicaoParaNorteQuandoLimiteMaximoParaLesteForAtingido() throws Exception {
		terreno = new Terreno(5, 5);
		terreno.virarDireita(); // Leste
		andarPosicoes(5);
		terreno.virarEsquerda();

		terreno.andar();
		
		assertEquals(Integer.valueOf(5), terreno.getCoordenadaX());
		assertEquals(Integer.valueOf(1), terreno.getCoordenadaY());
	}
	
	@Test
	public void deveAndarUmaPosicaoParaLesteQuandoLimiteMaximoParaNorteForAtingido() throws Exception {
		terreno = new Terreno(5, 5);
		andarPosicoes(5);
		terreno.virarDireita(); // Leste

		terreno.andar();
		
		assertEquals(Integer.valueOf(1), terreno.getCoordenadaX());
		assertEquals(Integer.valueOf(5), terreno.getCoordenadaY());
	}
	
	@Test
	public void deveAndarUmaPosicaoParaSulQuandoLimiteMinimoParaOesteForAtingido() throws Exception {
		terreno = new Terreno(5, 5);
		andarPosicoes(1);
		terreno.virarDireita(); // Leste
		terreno.virarDireita(); // Sul

		terreno.andar();
		
		assertEquals(Integer.valueOf(0), terreno.getCoordenadaX());
		assertEquals(Integer.valueOf(0), terreno.getCoordenadaY());
	}
	
	@Test
	public void deveAndarUmaPosicaoParaOesteQuandoLimiteMinimoParaSulForAtingido() throws Exception {
		terreno = new Terreno(5, 5);
		terreno.virarDireita(); // Leste
		andarPosicoes(1);
		terreno.virarDireita(); // Sul
		terreno.virarDireita(); // Oeste

		terreno.andar();
		
		assertEquals(Integer.valueOf(0), terreno.getCoordenadaX());
		assertEquals(Integer.valueOf(0), terreno.getCoordenadaY());
	}

	private void posicionarNorte() {
		this.terreno = novoTerrenoPadrao();
	}

	private void posicionarLeste() {
		posicionarNorte();
		this.terreno.virarDireita();
	}

	private void posicionarSul() {
		posicionarLeste();
		this.terreno.virarDireita();
	}

	private void posicionarOeste() {
		posicionarSul();
		this.terreno.virarDireita();
	}

	private void andarPosicoes(int posicoes) throws LimiteTerrenoException {
		for (int i = 0; i < posicoes; i++) {
			this.terreno.andar();
		}
	}
}
