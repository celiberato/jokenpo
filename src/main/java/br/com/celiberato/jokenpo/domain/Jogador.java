package br.com.celiberato.jokenpo.domain;

import lombok.AccessLevel;
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
public class Jogador extends AbstractEntity {

	static final long serialVersionUID = 1l;

	private String nomeJogador;
	
	public Jogador(String nomeJogadorIniciador) {
		this.nomeJogador = nomeJogadorIniciador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeJogador == null) ? 0 : nomeJogador.hashCode());
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
		Jogador other = (Jogador) obj;
		if (nomeJogador == null) {
			if (other.nomeJogador != null)
				return false;
		} else if (!nomeJogador.equals(other.nomeJogador))
			return false;
		return true;
	}


}