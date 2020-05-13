package br.com.celiberato.jokenpo.domain;

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
public class ResultadoPartida extends AbstractEntity {

	static final long serialVersionUID = 1l;

	private Partida partida;

	private Jogador jogadorVencedor;

	
}