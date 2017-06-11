/**
 * 
 */
package co.com.ias.pruebatecnica.ws.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ias.pruebatecnica.ws.dao.IZonaDao;
import co.com.ias.pruebatecnica.ws.domain.Zona;
import co.com.ias.pruebatecnica.ws.dto.ZonaDto;
import co.com.ias.pruebatecnica.ws.service.IZonaService;
import co.com.ias.pruebatecnica.ws.support.AdmonLogger;

/**
 * 
 * @author gtorress
 *
 */
@Service("ZonaServiceImpl")
@Transactional
public class ZonaServiceImpl extends ServiceImpl<Zona, ZonaDto> implements IZonaService {
	/**
	 * instancia logger
	 */
	@SuppressWarnings("unused")
	private static final AdmonLogger LOGGER = AdmonLogger.getInstance(Logger.getLogger(ZonaServiceImpl.class));

	@SuppressWarnings("unused")
	private IZonaDao iZonaDao;

	/**
	 * Dependencia Dao de Zona
	 */

	@Autowired
	public ZonaServiceImpl(IZonaDao iZonaDao) {
		super(iZonaDao, Zona.class);
		this.iZonaDao = iZonaDao;
	}
}
