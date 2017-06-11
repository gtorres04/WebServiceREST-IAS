/**
 * 
 */
package co.com.ias.pruebatecnica.ws.dao;

import java.util.List;

import co.com.ias.pruebatecnica.ws.domain.Ave;
import co.com.ias.pruebatecnica.ws.domain.Zona;

/**
 * @author gtorress
 *
 */
public interface IAveDao extends IDaoGeneric<Ave> {

	/**
	 * Consultar las aves donde el nombre comun o cientifico coicida con el
	 * patronNombre y ademas que este en un pais correspondiente a la Zona
	 * seleccionada.
	 * 
	 * @param patronNombre
	 * @param zona
	 * @return
	 */
	List<Ave> consultarAvesPorNombresYZona(String patronNombre, Zona zona);

}
