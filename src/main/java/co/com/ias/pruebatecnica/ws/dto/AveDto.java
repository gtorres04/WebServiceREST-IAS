/**
 * 
 */
package co.com.ias.pruebatecnica.ws.dto;

import java.io.Serializable;

/**
 * @author gtorress
 *
 */
public class AveDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9208103715876625093L;

	private String codigo;
	
	private String nombreComun;
	
	private String nombreCientifico;

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
	 * @return the nombreComun
	 */
	public String getNombreComun() {
		return nombreComun;
	}

	/**
	 * @param nombreComun the nombreComun to set
	 */
	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}

	/**
	 * @return the nombreCientifico
	 */
	public String getNombreCientifico() {
		return nombreCientifico;
	}

	/**
	 * @param nombreCientifico the nombreCientifico to set
	 */
	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

}
