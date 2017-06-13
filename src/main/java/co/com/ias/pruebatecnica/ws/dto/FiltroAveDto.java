/**
 * 
 */
package co.com.ias.pruebatecnica.ws.dto;

import java.io.Serializable;

/**
 * @author gtorress
 *
 */
public class FiltroAveDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6608291486599674370L;


	private String nombre;

	private ZonaDto zonaDto;

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the zonaDto
	 */
	public ZonaDto getZonaDto() {
		return zonaDto;
	}

	/**
	 * @param zonaDto
	 *            the zonaDto to set
	 */
	public void setZonaDto(ZonaDto zonaDto) {
		this.zonaDto = zonaDto;
	}

}
