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
	@Column(name = "CDPAIS")
	private String idPais;
	
	@Id
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
