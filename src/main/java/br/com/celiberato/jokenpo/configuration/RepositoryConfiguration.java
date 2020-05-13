package br.com.celiberato.jokenpo.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"br.com.celiberato.jokenpo.domain"})
public class RepositoryConfiguration {
}
