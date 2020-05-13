package br.com.celiberato.jokenpo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


public class AbstractController {

	protected static final String ID_PATH_VARIABLE = "/{id:^(?!count|all).+}";

	@Autowired
	protected ModelMapper modelMapper;

}
