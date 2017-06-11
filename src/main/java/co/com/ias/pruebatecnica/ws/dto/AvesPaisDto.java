/**
 * 
 */
package co.com.ias.pruebatecnica.ws.dto;

import java.io.Serializable;

import co.com.ias.pruebatecnica.ws.domain.AvesPais;

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

	/**
	 * Retorna un Dto a partir de un dominio.
	 * @param dominio
	 * @return
	 */
	public static AvesPaisDto getDto(AvesPais dominio) {
		AvesPaisDto avesPaisDto = null;
		if(null != dominio){
			avesPaisDto = new AvesPaisDto();
			avesPaisDto.setPaisDto(PaisDto.getDto(dominio.getPais()));
			avesPaisDto.setAveDto(AveDto.getDto(dominio.getAve()));
		}
		return avesPaisDto;
	}

}
