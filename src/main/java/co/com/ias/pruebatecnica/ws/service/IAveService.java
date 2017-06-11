/**
 * 
 */
package co.com.ias.pruebatecnica.ws.service;

import java.util.List;

import co.com.ias.pruebatecnica.ws.dto.AveDto;
import co.com.ias.pruebatecnica.ws.dto.ZonaDto;

/**
 * @author gtorress
 *
 */
public interface IAveService extends IService<AveDto> {
	
	/**
	 * Consultar las aves donde el nombre comun o cientifico coicida con el
	 * patronNombre y ademas que este en un pais correspondiente a la Zona
	 * seleccionada.
	 * 
	 * @param patronNombre
	 * @param zonaDto
	 * @return
	 */
	List<AveDto> consultarAvesPorNombresYZona(String patronNombre, ZonaDto zonaDto);
	
}
