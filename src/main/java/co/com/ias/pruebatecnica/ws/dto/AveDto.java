/**
 * 
 */
package co.com.ias.pruebatecnica.ws.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import co.com.ias.pruebatecnica.ws.domain.Ave;

/**
 * @author gtorress
 *
 */
public class AveDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9208103715876625093L;

	private String codigo;

	private String nombreComun;

	private String nombreCientifico;

	private List<PaisDto> paises;

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
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
	 * @param nombreComun
	 *            the nombreComun to set
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
	 * @param nombreCientifico
	 *            the nombreCientifico to set
	 */
	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	/**
	 * @return the paises
	 */
	public List<PaisDto> getPaises() {
		return paises;
	}

	/**
	 * @param paises
	 *            the paises to set
	 */
	public void setPaises(List<PaisDto> paises) {
		this.paises = paises;
	}

	/**
	 * Se obtiene una lista de Dto a partir de una lista de dominio.
	 * 
	 * @param aves
	 * @return
	 */
	public static List<AveDto> getDto(List<Ave> aves) {
		List<AveDto> aveDtos = null;
		if (null != aves) {
			aveDtos = new ArrayList<>();
			for (Ave ave : aves) {
				aveDtos.add(getDto(ave));
			}
			aveDtos = aveDtos.isEmpty() ? null : aveDtos;
		}
		return aveDtos;
	}

	/**
	 * Se obtiene un Dto a partir de dominio.
	 * 
	 * @param ave
	 * @return
	 */
	public static AveDto getDto(Ave ave) {
		AveDto aveDto = null;
		if (null != ave) {
			aveDto = new AveDto();
			BeanUtils.copyProperties(ave, aveDto);
		}
		return aveDto;
	}

	/**
	 * Se obtiene un dominio a partir de un Dto.
	 * @param object
	 * @return
	 */
	public static Ave getDomain(AveDto object) {
		Ave ave = null;
		if (null != object) {
			ave = new Ave();
			BeanUtils.copyProperties(object, ave);
		}
		return ave;
	}

}
