package br.com.celiberato.jokenpo.repositories;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.celiberato.jokenpo.configuration.RepositoryConfiguration;
import br.com.celiberato.jokenpo.constants.JogadasConstants;
import br.com.celiberato.jokenpo.domain.Jogada;
import br.com.celiberato.jokenpo.domain.Jogador;
import br.com.celiberato.jokenpo.domain.Partida;
import br.com.celiberato.jokenpo.exception.JokenpoException;
import br.com.celiberato.jokenpo.services.JokenpoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class JokenpoServiceTest extends BaseControllerIT {

	public static final String JOGADOR_JOSE = "José";
	public static final String JOGADOR_MARIO = "Mario";
	public static final String JOGADOR_CAMILA = "Camila";
	public static final String JOGADOR_CELMA = "Celma";

	JokenpoService jokenpoService = new JokenpoService();


	@Before
	public void setUp() {
	}
		
	@Test	
	public void testCenario1() throws JokenpoException, URISyntaxException {

		Partida partida = jokenpoService.iniciarPartida(JOGADOR_MARIO);

		partida = jokenpoService.adicionarJogador(partida, JOGADOR_JOSE);
		partida = jokenpoService.adicionarJogador(partida, JOGADOR_MARIO);
		partida = jokenpoService.adicionarJogador(partida, JOGADOR_CAMILA);

	
		partida = jokenpoService.adicionarJogada(partida, JOGADOR_CAMILA, JogadasConstants.JOGADA_PAPEL);
		partida = jokenpoService.adicionarJogada(partida, JOGADOR_JOSE, JogadasConstants.JOGADA_PEDRA);
		partida = jokenpoService.adicionarJogada(partida, JOGADOR_MARIO, JogadasConstants.JOGADA_TESOURA);
		
		Jogador vencedor = jokenpoService.calcularVencedor(partida);
		
		assertEquals(vencedor.getNomeJogador(), JOGADOR_JOSE);

	}

	@Test	
	public void testCenario2() throws JokenpoException, URISyntaxException {

		Partida partida = jokenpoService.iniciarPartida(JOGADOR_MARIO);

		partida = jokenpoService.adicionarJogador(partida, JOGADOR_JOSE);
		partida = jokenpoService.adicionarJogador(partida, JOGADOR_MARIO);
		partida = jokenpoService.adicionarJogador(partida, JOGADOR_CAMILA);

	
		partida = jokenpoService.adicionarJogada(partida, JOGADOR_CAMILA, JogadasConstants.JOGADA_PAPEL);
		partida = jokenpoService.adicionarJogada(partida, JOGADOR_JOSE, JogadasConstants.JOGADA_PEDRA);
		partida = jokenpoService.adicionarJogada(partida, JOGADOR_MARIO, JogadasConstants.JOGADA_PEDRA);
		
		Jogador vencedor = jokenpoService.calcularVencedor(partida);
		
		assertEquals(vencedor, null);

	}

	@Test	
	public void testCenario3() throws JokenpoException, URISyntaxException {

		Partida partida = jokenpoService.iniciarPartida(JOGADOR_MARIO);

		partida = jokenpoService.adicionarJogador(partida, JOGADOR_JOSE);
		partida = jokenpoService.adicionarJogador(partida, JOGADOR_MARIO);
		partida = jokenpoService.adicionarJogador(partida, JOGADOR_CAMILA);

	
		partida = jokenpoService.adicionarJogada(partida, JOGADOR_CAMILA, JogadasConstants.JOGADA_TESOURA);
		partida = jokenpoService.adicionarJogada(partida, JOGADOR_JOSE, JogadasConstants.JOGADA_PAPEL);
		partida = jokenpoService.adicionarJogada(partida, JOGADOR_MARIO, JogadasConstants.JOGADA_PAPEL);
		
		Jogador vencedor = jokenpoService.calcularVencedor(partida);
		
		assertEquals(vencedor.getNomeJogador(), JOGADOR_CAMILA);

	}

	@Test	
	public void testCenario4() throws JokenpoException, URISyntaxException {

		Partida partida = jokenpoService.iniciarPartida(JOGADOR_MARIO);

		partida = jokenpoService.adicionarJogador(partida, JOGADOR_JOSE);
		partida = jokenpoService.adicionarJogador(partida, JOGADOR_MARIO);
		partida = jokenpoService.adicionarJogador(partida, JOGADOR_CAMILA);
		partida = jokenpoService.adicionarJogador(partida, JOGADOR_CELMA);

	
		partida = jokenpoService.adicionarJogada(partida, JOGADOR_CAMILA, JogadasConstants.JOGADA_PAPEL);
		partida = jokenpoService.adicionarJogada(partida, JOGADOR_JOSE, JogadasConstants.JOGADA_PAPEL);
		partida = jokenpoService.adicionarJogada(partida, JOGADOR_MARIO, JogadasConstants.JOGADA_PAPEL);
		partida = jokenpoService.adicionarJogada(partida, JOGADOR_CELMA, JogadasConstants.JOGADA_TESOURA);
			
		Jogador vencedor = jokenpoService.calcularVencedor(partida);
		
		assertEquals(vencedor.getNomeJogador(), JOGADOR_CELMA);

	}

	@Test	
	public void testJogadorDuplicado() throws JokenpoException, URISyntaxException {

		Partida partida = jokenpoService.iniciarPartida(JOGADOR_MARIO);

		partida = jokenpoService.adicionarJogador(partida, JOGADOR_JOSE);
		partida = jokenpoService.adicionarJogador(partida, JOGADOR_MARIO);
		partida = jokenpoService.adicionarJogador(partida, JOGADOR_CAMILA);

		try {
			partida = jokenpoService.adicionarJogador(partida, JOGADOR_JOSE);
			
			assertTrue(false);
		} catch (JokenpoException e) {
			assertTrue(true);
		}
	

	}

	@Test	
	public void testJogadaJogadorNaoExiste() throws JokenpoException, URISyntaxException {

		Partida partida = jokenpoService.iniciarPartida(JOGADOR_MARIO);

		partida = jokenpoService.adicionarJogador(partida, JOGADOR_JOSE);
		partida = jokenpoService.adicionarJogador(partida, JOGADOR_MARIO);
		partida = jokenpoService.adicionarJogador(partida, JOGADOR_CAMILA);

		try {
			partida = jokenpoService.adicionarJogada(partida, JOGADOR_CELMA, JogadasConstants.JOGADA_PAPEL);
			assertTrue(false);
		} catch (JokenpoException e) {
			assertTrue(true);
		}
	

	}

	@Test	
	public void testRemoverJogada() throws JokenpoException, URISyntaxException {

		Partida partida = jokenpoService.iniciarPartida(JOGADOR_MARIO);

		partida = jokenpoService.adicionarJogador(partida, JOGADOR_JOSE);
		partida = jokenpoService.adicionarJogador(partida, JOGADOR_MARIO);
		partida = jokenpoService.adicionarJogador(partida, JOGADOR_CAMILA);
		partida = jokenpoService.adicionarJogador(partida, JOGADOR_CELMA);

	
		partida = jokenpoService.adicionarJogada(partida, JOGADOR_CAMILA, JogadasConstants.JOGADA_TESOURA);
		partida = jokenpoService.adicionarJogada(partida, JOGADOR_JOSE, JogadasConstants.JOGADA_PAPEL);
		partida = jokenpoService.adicionarJogada(partida, JOGADOR_MARIO, JogadasConstants.JOGADA_PEDRA);
		partida = jokenpoService.adicionarJogada(partida, JOGADOR_CELMA, JogadasConstants.JOGADA_PEDRA);
		
		
		jokenpoService.removerJogada(partida, new Jogada(new Jogador(JOGADOR_CELMA), JogadasConstants.JOGADA_PEDRA));
		
		Jogador vencedor = jokenpoService.calcularVencedor(partida);
		
		assertEquals(vencedor.getNomeJogador(), JOGADOR_MARIO);

	}

}
