package br.com.celiberato.jokenpo.domain;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Long id = System.currentTimeMillis();


}
