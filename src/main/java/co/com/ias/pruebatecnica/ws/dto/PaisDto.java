/**
 * 
 */
package co.com.ias.pruebatecnica.ws.dto;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import co.com.ias.pruebatecnica.ws.domain.Pais;

/**
 * @author gtorress
 *
 */
public class PaisDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6608291486599674370L;

	private String codigo;

	private String nombre;

	private ZonaDto zonaDto;

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

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

	/**
	 * Retorna un Dto a partir de un dominio.
	 * @param pais
	 * @return
	 */
	public static PaisDto getDto(Pais pais) {
		PaisDto paisDto = null;
		if (null != pais) {
			paisDto = new PaisDto();
			BeanUtils.copyProperties(pais, paisDto);
			paisDto.setZonaDto(ZonaDto.getDto(pais.getZona()));
		}
		return paisDto;
	}

}
