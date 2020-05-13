package br.com.celiberato.jokenpo.configuration;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Configuration
public class JacksonAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public Module jsonMapperJava8DateTimeModule(Formatter<LocalDate> localDateFormatter, Formatter<LocalTime> localTimeFormatter, Formatter<LocalDateTime> localDateTimeFormatter) {
		SimpleModule module = new SimpleModule();

		
		module.addDeserializer(LocalDate.class, new JsonDeserializer<LocalDate>() {

			@Override
			public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
				try {
					return localDateFormatter.parse(jsonParser.getValueAsString(), null);

				} catch (ParseException e) {
					throw new IOException(e);
				}
			}
		});

		module.addDeserializer(LocalTime.class, new JsonDeserializer<LocalTime>() {

			@Override
			public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
				try {
					return localTimeFormatter.parse(jsonParser.getValueAsString(), null);

				} catch (ParseException e) {
					throw new IOException(e);
				}
			}
		});

		module.addDeserializer(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {

			@Override
			public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
				try {
					return localDateTimeFormatter.parse(jsonParser.getValueAsString(), null);

				} catch (ParseException e) {
					throw new IOException(e);
				}
			}
		});

		return module;
	}
	}