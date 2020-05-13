package br.com.celiberato.jokenpo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder 
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PROTECTED)
public class Partida extends AbstractEntity {

	static final long serialVersionUID = 1l;

	private Jogador jogadorIniciador;
	
    private List<Jogador> jogadores = new ArrayList<>();
 
    private List<Jogada> jogadas = new ArrayList<>();

    public Partida(String nomeJogadorIniciador) {
    	this.jogadorIniciador = new Jogador(nomeJogadorIniciador);
    }
 }