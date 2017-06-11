/**
 * 
 */
package co.com.ias.pruebatecnica.ws.dao.exception;

import java.util.List;

/**
 * Excepcion generica de la capa DAO
 * 
 * @author gtorress
 *
 */
public class DaoGenericException extends RuntimeException {

	/**
	 * nombre de la columnas de la tabla relacionadas al error lanzado por la base de datos.
	 */
	private List<String> nombresColumnasAfectadas;
	/**
	 * dato que se intenta registrar en la columna, de la tabla en la que se
	 * realiza la transaccion
	 */
	private String datoProblema;
	/**
	 * nombre de la restriccion que ejecuta la validacion
	 */
	private String restriccion;
	/**
	 * Mensaje que envia Dao correspondiente a la exception gestionada
	 */
	private String mensaje;

	/**
	 * nombre del esquema sobre el que se esta trabajando
	 */
	private String esquema;
	/**
	 * nombre de la tabla donde se intenta la transaccion.
	 */
	private String nombreTabla;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor que recibe la exception original
	 * 
	 * @param e
	 */
	public DaoGenericException(Exception e) {
		super(e);
	}

	/**
	 * Constructor mensaje estandar, usa constructor del padre "Exception(String
	 * message)"
	 * 
	 * @param message
	 */
	public DaoGenericException(String message) {
		super(message);
	}

	/**
	 * Constructor mensaje estandar y la exception original, usa constructor del
	 * padre "Exception(String message, Throwable cause)"
	 * 
	 * @param message
	 * @param cause
	 */
	public DaoGenericException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor que inicializa los atributos nombreColumna, datoProblema y
	 * restriccion
	 * 
	 * @param nombreColumna
	 * @param datoProblema
	 * @param restriccion
	 * @param mensaje
	 */
	public DaoGenericException(List<String> nombresColumnas,String  datoProblema, String restriccion) {
		this.nombresColumnasAfectadas = nombresColumnas;
		this.datoProblema = datoProblema;
		this.restriccion = restriccion;
	}

	/**
	 * @return the nombresColumnasAfectadas
	 */
	public List<String> getNombresColumnasAfectadas() {
		return nombresColumnasAfectadas;
	}

	/**
	 * @param nombresColumnasAfectadas the nombresColumnasAfectadas to set
	 */
	public void setNombresColumnasAfectadas(List<String> nombresColumnasAfectadas) {
		this.nombresColumnasAfectadas = nombresColumnasAfectadas;
	}

	/**
	 * @return the datoProblema
	 */
	public String getDatoProblema() {
		return datoProblema;
	}

	/**
	 * @param datoProblema
	 *            the datoProblema to set
	 */
	public void setDatoProblema(String datoProblema) {
		this.datoProblema = datoProblema;
	}

	/**
	 * @return the restriccion
	 */
	public String getRestriccion() {
		return restriccion;
	}

	/**
	 * @param restriccion
	 *            the restriccion to set
	 */
	public void setRestriccion(String restriccion) {
		this.restriccion = restriccion;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the esquema
	 */
	public String getEsquema() {
		return esquema;
	}

	/**
	 * @param esquema
	 *            the esquema to set
	 */
	public void setEsquema(String esquema) {
		this.esquema = esquema;
	}

	/**
	 * @return the nombreTabla
	 */
	public String getNombreTabla() {
		return nombreTabla;
	}

	/**
	 * @param nombreTabla
	 *            the nombreTabla to set
	 */
	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}

}
