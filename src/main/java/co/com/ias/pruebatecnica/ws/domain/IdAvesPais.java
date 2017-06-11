/**
 * 
 */
package co.com.ias.pruebatecnica.ws.domain;

import java.io.Serializable;

/**
 * @author gtorress
 *
 */
public class IdAvesPais implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7254663360716583367L;

	private Pais pais;

	private Ave ave;

	/**
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/**
	 * @return the ave
	 */
	public Ave getAve() {
		return ave;
	}

	/**
	 * @param ave the ave to set
	 */
	public void setAve(Ave ave) {
		this.ave = ave;
	}
	
}
