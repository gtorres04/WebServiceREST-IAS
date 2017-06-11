/**
 * 
 */
package co.com.ias.pruebatecnica.ws.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author gtorress
 *
 */
@Entity
@Table(name = "TONT_AVES_PAIS")
@IdClass (IdAvesPais.class)
public class AvesPais implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5529743341102624742L;

	@Id
	@Column
	private Pais pais;
	
	@Id
	@Column
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
