/**
 * 
 */
package co.com.ias.pruebatecnica.ws.domain;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author gtorress
 *
 */
public class IdAvesPais implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7254663360716583367L;

	@Column(name = "CDPAIS")
	private String idPais;

	@Column(name = "CDAVE")
	private String idAve;

	/**
	 * @return the idPais
	 */
	public String getIdPais() {
		return idPais;
	}

	/**
	 * @param idPais the idPais to set
	 */
	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

	/**
	 * @return the idAve
	 */
	public String getIdAve() {
		return idAve;
	}

	/**
	 * @param idAve the idAve to set
	 */
	public void setIdAve(String idAve) {
		this.idAve = idAve;
	}

	
	
}
