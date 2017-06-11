/**
 * 
 */
package co.com.ias.pruebatecnica.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ias.pruebatecnica.ws.dao.IPaisDao;
import co.com.ias.pruebatecnica.ws.dao.exception.DaoGenericException;
import co.com.ias.pruebatecnica.ws.domain.Pais;
import co.com.ias.pruebatecnica.ws.dto.PaisDto;
import co.com.ias.pruebatecnica.ws.service.IPaisService;
import co.com.ias.pruebatecnica.ws.service.exception.CuposServiceException;
import co.com.ias.pruebatecnica.ws.support.AdmonLogger;

/**
 * 
 * @author gtorress
 *
 */
@Service("PaisServiceImpl")
@Transactional
public class PaisServiceImpl extends ServiceImpl<Pais, PaisDto> implements IPaisService {
	/**
	 * instancia logger
	 */
	private static final AdmonLogger LOGGER = AdmonLogger.getInstance(Logger.getLogger(PaisServiceImpl.class));

	@SuppressWarnings("unused")
	private IPaisDao iPaisDao;

	/**
	 * Dependencia Dao de Pais
	 */

	@Autowired
	public PaisServiceImpl(IPaisDao iPaisDao) {
		super(iPaisDao, Pais.class);
		this.iPaisDao = iPaisDao;
	}
	
	/* (non-Javadoc)
	 * @see co.com.ias.pruebatecnica.ws.service.impl.ServiceImpl#findAll(java.lang.Class)
	 */
	@Override
	public List<PaisDto> findAll(Class<PaisDto> clase){
		List<PaisDto> dtos = null;
		List<Pais> dominios = null;
		try {
			dominios = iDaoGeneric.findAll(Pais.class);
			if (dominios != null) {
				dtos = new ArrayList<>();
				for (Pais dominio : dominios) {
					PaisDto dto = PaisDto.getDto(dominio);
					dtos.add(dto);
				}
			}
		} catch (DaoGenericException e) {
			LOGGER.debug(e);
			throw new CuposServiceException(e);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new CuposServiceException(e);
		}
		return dtos;
	}
}
