package co.com.ias.pruebatecnica.ws.service.exception;

import java.util.ArrayList;
import java.util.List;

public class CuposServiceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6205153315236921214L;

	private final List<String> mensajes;
	
	/**
	 * @param message
	 */
	public CuposServiceException(String message) {
		super(message);
		mensajes = new ArrayList<>();
		mensajes.add(message);
	}
	
	/**
	 * @param message
	 */
	public CuposServiceException(List<String> message) {
		mensajes = message;
	}


	/**
	 * @param cause
	 */
	public CuposServiceException(Throwable cause) {
		super(cause);
		mensajes=null;
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CuposServiceException(String message, Throwable cause) {
		super(message, cause);
		mensajes = new ArrayList<>();
		mensajes.add(message);

	}


	/**
	 * @return the mensajes
	 */
	public List<String> getMensajes() {
		return mensajes;
	}
}
