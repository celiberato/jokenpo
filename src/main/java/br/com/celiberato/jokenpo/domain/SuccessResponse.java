package br.com.celiberato.jokenpo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuccessResponse {

	private Integer code;

	@Builder.Default
	private HttpStatus status = HttpStatus.OK;

	private String message;

	public Integer getCode() {
		return code == null && status != null ? status.value() : code;
	}

}