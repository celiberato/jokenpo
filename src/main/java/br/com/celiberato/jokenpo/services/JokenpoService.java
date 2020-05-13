package br.com.celiberato.jokenpo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.celiberato.jokenpo.constants.JogadasConstants;
import br.com.celiberato.jokenpo.constants.MessagesConstants;
import br.com.celiberato.jokenpo.domain.Jogada;
import br.com.celiberato.jokenpo.domain.Jogador;
import br.com.celiberato.jokenpo.domain.Partida;
import br.com.celiberato.jokenpo.domain.ResultadoPartida;
import br.com.celiberato.jokenpo.exception.JokenpoException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JokenpoService {

	public Partida iniciarPartida(String nomeJogadorIniciador){
		Partida partida = new Partida(nomeJogadorIniciador);
		return partida;
	}

	public Partida adicionarJogador(Partida partida, String nomeJogador) throws JokenpoException{
		if(partida.getJogadores()==null) partida.setJogadores(new ArrayList<>());

		if(partida.getJogadores().stream().filter(jogador -> jogador.getNomeJogador().equals(nomeJogador))
				.collect(Collectors.toList()).size()>0) {
			throw new JokenpoException(MessagesConstants.JOGADOR_JA_CADASTRADO);
		}

    	partida.getJogadores().add(new Jogador(nomeJogador));
		return partida;
	}
	
	
	public Partida removerJogador(Partida partida, String nomeJogador) throws JokenpoException{
    	List<Jogador> jogadores = partida.getJogadores().stream()
    			.filter(jogador -> !jogador.getNomeJogador().equals(nomeJogador))
    			.collect(Collectors.toList());

    	if(jogadores.size()==partida.getJogadores().size()) {
    		throw new JokenpoException(MessagesConstants.JOGADOR_NAO_CADASTRADO);
    	}
    	
    	partida.setJogadores(jogadores);
    	return partida;
	}

	public Partida adicionarJogada(Partida partida, String nomeJogador, String objeto) throws JokenpoException{
		
		if(partida.getJogadores().stream().filter(jogador -> jogador.getNomeJogador().equals(nomeJogador))
				.collect(Collectors.toList()).size()==0) {
			throw new JokenpoException(MessagesConstants.JOGADOR_NAO_CADASTRADO);
		}
		
		if(!objeto.equals(JogadasConstants.JOGADA_PAPEL) && !objeto.equals(JogadasConstants.JOGADA_PEDRA) && !objeto.equals(JogadasConstants.JOGADA_TESOURA)) {
			throw new JokenpoException(MessagesConstants.JOGADA_NAO_PERMITIDA);
		}

		partida.getJogadas().add( new Jogada(new Jogador(nomeJogador), objeto));
		return partida;
	}

	
	public ResultadoPartida obterResultado(Partida partida) {
		
		Jogador jogadorVencedor = this.calcularVencedor(partida);
		
		ResultadoPartida resultado = ResultadoPartida.builder()
				.jogadorVencedor(jogadorVencedor)
				.build();
		
		return resultado;
	}
	
	public Jogador calcularVencedor(Partida partida) {
		int qtPedras = 0;
		int qtTesoura = 0;
		int qtPapel = 0;
		
	    Jogador jogadorVencedorPedro = null;
	    Jogador jogadorVencedorTesoura = null;
		
		for(Jogada jogada: partida.getJogadas()) {
			if(jogada.getObjeto().equals(JogadasConstants.JOGADA_PEDRA)) {
				qtPedras++;
				jogadorVencedorPedro = jogada.getJogador();
			} else if(jogada.getObjeto().equals(JogadasConstants.JOGADA_TESOURA)) {
				qtTesoura++;
				jogadorVencedorTesoura = jogada.getJogador();
			} else if(jogada.getObjeto().equals(JogadasConstants.JOGADA_PAPEL)) {
				qtPapel++;
			}
		}

		if(qtPedras==1) {
			return jogadorVencedorPedro;
		} else if(qtTesoura==1) {
			return jogadorVencedorTesoura;
		} else {
			return null;
		}
	}

    public Partida removerJogada(Partida partida, Jogada jogadaRemover) throws JokenpoException{
    	if(!partida.getJogadas().remove(jogadaRemover)) {
    		throw new JokenpoException(MessagesConstants.JOGADA_EXCLUSAO_NAO_PERMITIDA);
    	}

    	return partida;
    }

}