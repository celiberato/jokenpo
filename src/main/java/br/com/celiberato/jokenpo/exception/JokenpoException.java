package br.com.celiberato.jokenpo.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

import br.com.celiberato.jokenpo.domain.FieldError;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JokenpoException extends Exception {

	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

	private List<FieldError> fieldErrors;

	public JokenpoException(Exception exception) {
		super(exception);
	}

	public JokenpoException(Exception exception, HttpStatus httpStatus) {
		super(exception);
		this.httpStatus = httpStatus;
	}

	public JokenpoException(String message) {
		super(message);
	}

	public JokenpoException(String message, Exception exception) {
		super(message, exception);
	}

	public JokenpoException(String message, Exception exception, HttpStatus httpStatus) {
		super(message, exception);
		this.httpStatus = httpStatus;
	}

	public JokenpoException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public JokenpoException(List<FieldError> fieldErrors, HttpStatus httpStatus) {
		super(HttpStatus.BAD_REQUEST.getReasonPhrase());
		this.fieldErrors = fieldErrors;
		this.httpStatus = httpStatus;
	}

}