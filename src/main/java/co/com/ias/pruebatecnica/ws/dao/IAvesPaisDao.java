/**
 * 
 */
package co.com.ias.pruebatecnica.ws.dao;

import java.util.List;

import co.com.ias.pruebatecnica.ws.domain.Ave;
import co.com.ias.pruebatecnica.ws.domain.AvesPais;

/**
 * @author gtorress
 *
 */
public interface IAvesPaisDao extends IDaoGeneric<AvesPais> {

	/**
	 * Consultar las AvesPais de un Ave.
	 * @param ave
	 * @return
	 */
	List<AvesPais> findByAve(Ave ave);
	
}
