/**
 * 
 */
package co.com.ias.pruebatecnica.ws.dto;

import java.io.Serializable;

/**
 * @author gtorress
 *
 */
public class AvesPaisDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6816008249692024513L;

	private PaisDto paisDto;
	
	private AveDto aveDto;

	/**
	 * @return the paisDto
	 */
	public PaisDto getPaisDto() {
		return paisDto;
	}

	/**
	 * @param paisDto the paisDto to set
	 */
	public void setPaisDto(PaisDto paisDto) {
		this.paisDto = paisDto;
	}

	/**
	 * @return the aveDto
	 */
	public AveDto getAveDto() {
		return aveDto;
	}

	/**
	 * @param aveDto the aveDto to set
	 */
	public void setAveDto(AveDto aveDto) {
		this.aveDto = aveDto;
	}

}
