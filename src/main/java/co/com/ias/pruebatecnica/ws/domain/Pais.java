/**
 * 
 */
package co.com.ias.pruebatecnica.ws.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author gtorress
 *
 */
@Entity
@Table(name = "TONT_PAISES")
public class Pais implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5705406603308322038L;

	@Id
	@Column(name = "CDPAIS")
	private String codigo;
	
	@Column(name = "DSNOMBRE")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "CDZONA")
	private Zona zona;

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
	 * @return the zona
	 */
	public Zona getZona() {
		return zona;
	}

	/**
	 * @param zona the zona to set
	 */
	public void setZona(Zona zona) {
		this.zona = zona;
	}	
	
}
