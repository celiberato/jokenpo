package br.com.celiberato.jokenpo.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MessagesConstants {


	public static final String JOGADOR_JA_CADASTRADO = "Jogador já cadastrado!";

	public static final String JOGADOR_NAO_CADASTRADO = "Jogador não cadastrado!";

	public static final String JOGADA_NAO_PERMITIDA = "Jogada não permitida!";

	public static final String JOGADA_EXCLUSAO_NAO_PERMITIDA = "Jogada não pode ser excluído por não existe para o mesmo jogador!";
	
}
