package br.com.celiberato.jokenpo.tests.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public abstract class AbstractControllerIT {


	protected ModelMapper modelMapper =  new ModelMapper();


	public HttpHeaders getHeaders(final String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Bearer " + token);

		return headers;
	}
}
