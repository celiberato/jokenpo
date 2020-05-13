package br.com.celiberato.jokenpo.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.celiberato.jokenpo.component.Message;

@Configuration
@ConditionalOnClass(Message.class)
public class MessageAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public Message message(MessageSource messageSource) {
		return new Message(messageSource);
	}

}
