package br.com.celiberato.jokenpo.repositories;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import br.com.celiberato.jokenpo.tests.controller.AbstractControllerIT;


public abstract class BaseControllerIT extends AbstractControllerIT {

	public static final String accessToken = "";
	
	protected int getCurrentTimeMillis() {
		return (int) (System.currentTimeMillis() / 1000);
	}

	protected HttpEntity<?> getRequestEntity() {     
		return new HttpEntity<>(getHeaders(accessToken));
	}

	protected <T> org.springframework.http.HttpEntity<T> getRequestEntity(T object) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		return new org.springframework.http.HttpEntity<>(object, headers);
	}

}