package co.com.ias.pruebatecnica.ws.response.dto;

import java.io.Serializable;

/**
 * Clase para representar la lista de errores que envía el cliente durante la respuesta SOAP.
 * 
 * @author cristian.castillo
 * 
 */
public class ErrorDto implements Serializable {

	/**
	 * @return the exception
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * @param exception the exception to set
	 */
	public void setException(Exception exception) {
		this.exception = exception;
	}

	/**
	 * Atributo serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Código del error
	 */
	private String codigoError;

	/**
	 * Descripción del error
	 */
	private String descripcion;
	
	private Exception exception;

	/**
	 * Constructor por defecto
	 */
	public ErrorDto() {
		super();
	}

	/**
	 * Constructor completo
	 * 
	 * @param codigoError
	 * @param descripcion
	 */
	public ErrorDto(String codigoError, String descripcion) {
		super();
		this.codigoError = codigoError;
		this.descripcion = descripcion;
	}

	/**
	 * @return the codigoError
	 */
	public String getCodigoError() {
		return codigoError;
	}

	/**
	 * @param codigoError
	 *            the codigoError to set
	 */
	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
