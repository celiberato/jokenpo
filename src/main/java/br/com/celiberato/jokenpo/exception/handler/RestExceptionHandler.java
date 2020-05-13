package br.com.celiberato.jokenpo.exception.handler;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import br.com.celiberato.jokenpo.component.Message;
import br.com.celiberato.jokenpo.domain.ErrorResponse;
import br.com.celiberato.jokenpo.domain.FieldError;
import br.com.celiberato.jokenpo.exception.JokenpoException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private Message message;

	private static final String MSG_CAMPO_INVALIDO = "br.gov.sp.prodesp.ssp.dipol.commons.FORMATO_INVALIDO";

	private ResponseEntity<ErrorResponse> createResponseEntity(final Exception exception, final WebRequest request, final HttpStatus status) {
		ErrorResponse error = ErrorResponse.builder() //
				.message(message.get(exception)) //
				.details(request.getDescription(false)) //
				.timestamp(LocalDateTime.now()) //
				.build();

		return new ResponseEntity<>(error, status);
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorResponse> handleAccessDenied(AccessDeniedException ex, WebRequest request) {
		return createResponseEntity(ex, request, HttpStatus.FORBIDDEN);
	}

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<FieldError> fieldErrors = new ArrayList<>();

		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			fieldErrors.add(new FieldError(error.getObjectName(), error.getDefaultMessage()));
		}

		for (org.springframework.validation.FieldError error : ex.getBindingResult().getFieldErrors()) {
			fieldErrors.add(new FieldError(error.getField(), error.getDefaultMessage()));
		}

		ErrorResponse error = ErrorResponse.builder().message(status.getReasonPhrase()).details(request.getDescription(false)).fieldErros(fieldErrors).build();
		return new ResponseEntity<>(error, status);
	}

	@ExceptionHandler(JokenpoException.class)
	public ResponseEntity<ErrorResponse> handleBusiness(JokenpoException ex, WebRequest request) {
		ErrorResponse error = ErrorResponse.builder() //
				.message(message.get(ex)) //
				.details(request.getDescription(false)) //
				.timestamp(LocalDateTime.now()) //
				.fieldErros(ex.getFieldErrors()) //
				.build();

		return new ResponseEntity<>(error, ex.getHttpStatus());
	}

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		List<FieldError> fieldErrors = new ArrayList<>();

		for (ConstraintViolation<?> error : ex.getConstraintViolations()) {
			fieldErrors.add(new FieldError(((PathImpl) error.getPropertyPath()).getLeafNode().getName(), error.getMessage()));
		}

		ErrorResponse error = ErrorResponse.builder().message(HttpStatus.BAD_REQUEST.getReasonPhrase()).details(request.getDescription(false)).fieldErros(fieldErrors).build();
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex, WebRequest request) {
		return createResponseEntity(ex, request, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<FieldError> fieldErrors = new ArrayList<>();

		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			fieldErrors.add(new FieldError(error.getObjectName(), error.getDefaultMessage()));
		}

		for (org.springframework.validation.FieldError error : ex.getBindingResult().getFieldErrors()) {
			fieldErrors.add(new FieldError(error.getField(), error.getDefaultMessage()));
		}

		ErrorResponse error = ErrorResponse.builder().message(status.getReasonPhrase()).details(request.getDescription(false)).fieldErros(fieldErrors).build();
		return new ResponseEntity<>(error, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		InvalidFormatException invalidFormatException = (InvalidFormatException) ex.getCause();
		String field = invalidFormatException.getPath().get(0).getFieldName();
		String mensagem = message.get(MSG_CAMPO_INVALIDO);
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), null, null, Arrays.asList(new FieldError(field, mensagem)));
		return new ResponseEntity<>(error, status);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> otherErrors(Exception ex, WebRequest request) {
		log.error(ex.getMessage(), ex);
		return createResponseEntity(ex, request, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
