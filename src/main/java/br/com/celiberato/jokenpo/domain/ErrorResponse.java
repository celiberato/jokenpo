package br.com.celiberato.jokenpo.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

	@Builder.Default
	private LocalDateTime timestamp = LocalDateTime.now();

	private String message;
	private String details;

	@JsonInclude(value = Include.NON_NULL)
	private List<FieldError> fieldErros;

}
