package br.com.fredericci.view;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldBean {

	public String umMetodoComNomeComprido(String ae) {
		return String.format("Hello from PrimeFaces and Spring Boot! %s", ae);
	}

}
