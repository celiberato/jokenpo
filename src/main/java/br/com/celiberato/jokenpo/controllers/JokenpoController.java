package br.com.celiberato.jokenpo.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.celiberato.jokenpo.domain.Jogada;
import br.com.celiberato.jokenpo.domain.Jogador;
import br.com.celiberato.jokenpo.domain.Partida;
import br.com.celiberato.jokenpo.domain.ResultadoPartida;
import br.com.celiberato.jokenpo.exception.JokenpoException;
import br.com.celiberato.jokenpo.services.JokenpoService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import springfox.documentation.annotations.ApiIgnore;


@RestController(value = "/jokenpo")
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JokenpoController extends BaseController {


	@Autowired
	JokenpoService jokenpoService;

	@PostMapping(value = "/iniciarPartida", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Partida iniciarPartida(String nomeJogador) throws JokenpoException {	
		return jokenpoService.iniciarPartida(nomeJogador);
	}

	@PostMapping(value = "/adicionarJogador", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Partida adicionarJogador(@RequestBody @Valid final Partida partida, String nomeJogador) throws JokenpoException {
		return jokenpoService.adicionarJogador(partida, nomeJogador);
	}
	
	
	@DeleteMapping(value = "/removerJogador")
	@ResponseStatus(HttpStatus.OK)
	public Partida removerJogador(@RequestBody @Valid final Partida partida, String nomeJogador) throws JokenpoException{
		return jokenpoService.removerJogador(partida, nomeJogador);
	}

	@DeleteMapping(value = "/removerJogada")
	@ResponseStatus(HttpStatus.OK)
	public Partida removerJogada(@RequestBody @Valid final Partida partida, String nomeJogador, String objeto) throws JokenpoException{
		return jokenpoService.removerJogada(partida, new Jogada(new Jogador(nomeJogador), objeto));
	}

	@PostMapping(value = "/adicionarJogada", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Partida adicionarJogada(@RequestBody @Valid final Partida partida, String nomeJogador, String objeto, @ApiIgnore Principal principal) throws JokenpoException {
		return jokenpoService.adicionarJogada(partida, nomeJogador, objeto);
	}

	
	@GetMapping("/obterResultado")
	@ResponseStatus(HttpStatus.OK)
	public ResultadoPartida obterResultado(@RequestBody @Valid final Partida partida) throws JokenpoException {
		
		Jogador jogadorVencedor = jokenpoService.calcularVencedor(partida);
		
		ResultadoPartida resultado = ResultadoPartida.builder()
				.jogadorVencedor(jogadorVencedor)
				.partida(partida)
				.build();
		
		return resultado;
	}

}
