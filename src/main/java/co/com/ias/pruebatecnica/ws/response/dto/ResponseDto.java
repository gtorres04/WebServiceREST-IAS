package co.com.ias.pruebatecnica.ws.response.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que mapea el resultado de la invocación de los servicios.
 * 
 * @author gerlin.torres
 * 
 */
/**
 * @author cristian.castillo
 *
 */
public class ResponseDto implements Serializable{
	
	/**
	 * Atributo serializable
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	protected boolean ejecucion;
	
	/**
	 * Código del resultado
	 */
	protected byte codigo;
	
	/**
	 * Descripción del resultado obtenido
	 */
	protected String descripcion;
	
	/**
	 * Mensaje de error
	 */
	protected List<ErrorDto> listaError;
	
	/**
	 * @return the ejecucion
	 */
	public boolean isEjecucion() {
		return ejecucion;
	}
	/**
	 * @param ejecucion the ejecucion to set
	 */
	public void setEjecucion(boolean ejecucion) {
		this.ejecucion = ejecucion;
	}
	/**
	 * @return the codigo
	 */
	public byte getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(byte codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<ErrorDto> getListaError() {
		return listaError;
	}
	
	public void setListaError(List<ErrorDto> listaError) {
		this.listaError = listaError;
	}
	
}
