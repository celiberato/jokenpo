package br.com.celiberato.jokenpo.component;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.MessageSourceAccessor;

import lombok.Getter;

@Getter
public class Message {

	public static final String BASE_NAME = "br.com.celiberato.jokenpo";

	private MessageSource source;
	private MessageSourceAccessor accessor;

	public Message(MessageSource source) {
		this.source = source;
		accessor = new MessageSourceAccessor(source, new Locale("pt", "BR"));
	}

	public String get(Exception exception) {
		if (exception == null) {
			return null;
		}

		String exceptionMessage = exception.getLocalizedMessage() != null ? exception.getLocalizedMessage() : exception.getMessage();

		if (exception.getMessage() != null && exception.getMessage().contains(BASE_NAME)) {
			try {
				return get(exception.getMessage());
			} catch (NoSuchMessageException e) {
				return exceptionMessage;
			}
		}

		return exceptionMessage;
	}

	public String get(String code) {
		return accessor.getMessage(code);
	}

}
