/**
 * 
 */
package co.com.ias.pruebatecnica.ws.dto;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import co.com.ias.pruebatecnica.ws.domain.Zona;

/**
 * @author gtorress
 *
 */
public class ZonaDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7052566338522916119L;

	private String codigo;
	
	private String nombre;

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
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
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Retorna un Dto a partir de un dominio.
	 * @param zona
	 * @return
	 */
	public static ZonaDto getDto(Zona zona) {
		ZonaDto zonaDto = null;
		if(null != zona){
			zonaDto = new ZonaDto();
			BeanUtils.copyProperties(zona, zonaDto);
		}
		return zonaDto;
	}	
}
