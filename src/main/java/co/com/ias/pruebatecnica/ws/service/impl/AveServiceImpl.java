/**
 * 
 */
package co.com.ias.pruebatecnica.ws.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ias.pruebatecnica.ws.dao.IAveDao;
import co.com.ias.pruebatecnica.ws.domain.Ave;
import co.com.ias.pruebatecnica.ws.dto.AveDto;
import co.com.ias.pruebatecnica.ws.service.IAveService;
import co.com.ias.pruebatecnica.ws.support.AdmonLogger;

/**
 * 
 * @author gtorress
 *
 */
@Service("AveServiceImpl")
public class AveServiceImpl extends ServiceImpl<Ave, AveDto> implements IAveService {
	/**
	 * instancia logger
	 */
	@SuppressWarnings("unused")
	private static final AdmonLogger LOGGER = AdmonLogger.getInstance(Logger.getLogger(AveServiceImpl.class));

	@SuppressWarnings("unused")
	private IAveDao iAveDao;

	/**
	 * Dependencia Dao de Ave
	 */

	@Autowired
	public AveServiceImpl(IAveDao iAveDao) {
		super(iAveDao, Ave.class);
		this.iAveDao = iAveDao;
	}
}
