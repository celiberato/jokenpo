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
@FieldDefaults(level = AccessLevel.PROTECTED)
public class Jogada extends AbstractEntity {

	static final long serialVersionUID = 1l;

	String objeto;
	Jogador jogador;
	
	public Jogada(Jogador jogador, String objeto) {
		this.jogador = jogador;
		this.objeto = objeto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jogador == null) ? 0 : jogador.hashCode());
		result = prime * result + ((objeto == null) ? 0 : objeto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogada other = (Jogada) obj;
		if (jogador == null) {
			if (other.jogador != null)
				return false;
		} else if (!jogador.equals(other.jogador))
			return false;
		if (objeto == null) {
			if (other.objeto != null)
				return false;
		} else if (!objeto.equals(other.objeto))
			return false;
		return true;
	}
	
	
}