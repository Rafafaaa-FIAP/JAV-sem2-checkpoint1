package br.com.restaurante.exceptions;

public class OpcaoInvalidoException extends NullPointerException {

	public OpcaoInvalidoException(String mensagem) {
		super(mensagem);
	}
	
}
