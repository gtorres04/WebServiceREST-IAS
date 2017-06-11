/**
 * 
 */
package co.com.ias.pruebatecnica.ws.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author gtorress
 *
 */
@Entity
@Table(name = "TONT_AVES")
public class Ave implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7818091363790866356L;

	@Id
	@Column(name = "CDAVE")
	private String codigo;
	
	@Column(name = "DSNOMBRE_COMUN")
	private String nombreComun;
	
	@Column(name = "DSNOMBRE_CIENTIFICO")
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
