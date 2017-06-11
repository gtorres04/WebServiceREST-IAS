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

import co.com.ias.pruebatecnica.ws.dao.IAvesPaisDao;
import co.com.ias.pruebatecnica.ws.dao.exception.DaoGenericException;
import co.com.ias.pruebatecnica.ws.domain.AvesPais;
import co.com.ias.pruebatecnica.ws.dto.AveDto;
import co.com.ias.pruebatecnica.ws.dto.AvesPaisDto;
import co.com.ias.pruebatecnica.ws.service.IAveService;
import co.com.ias.pruebatecnica.ws.service.IAvesPaisService;
import co.com.ias.pruebatecnica.ws.service.exception.CuposServiceException;
import co.com.ias.pruebatecnica.ws.support.AdmonLogger;

/**
 * 
 * @author gtorress
 *
 */
@Service("AvesPaisServiceImpl")
@Transactional
public class AvesPaisServiceImpl extends ServiceImpl<AvesPais, AvesPaisDto> implements IAvesPaisService {
	/**
	 * instancia logger
	 */
	private static final AdmonLogger LOGGER = AdmonLogger.getInstance(Logger.getLogger(AvesPaisServiceImpl.class));

	@SuppressWarnings("unused")
	private IAvesPaisDao iAvesPaisDao;
	
	@Autowired
	private IAveService iAveService;

	/**
	 * Dependencia Dao de Pais
	 */

	@Autowired
	public AvesPaisServiceImpl(IAvesPaisDao iAvesPaisDao) {
		super(iAvesPaisDao, AvesPais.class);
		this.iAvesPaisDao = iAvesPaisDao;
	}
	
	/* (non-Javadoc)
	 * @see co.com.ias.pruebatecnica.ws.service.impl.ServiceImpl#findAll(java.lang.Class)
	 */
	@Override
	public List<AvesPaisDto> findAll(Class<AvesPaisDto> clase){
		List<AvesPaisDto> dtos = null;
		List<AvesPais> dominios = null;
		try {
			dominios = iDaoGeneric.findAll(AvesPais.class);
			if (dominios != null) {
				dtos = new ArrayList<>();
				for (AvesPais dominio : dominios) {
					AvesPaisDto dto = AvesPaisDto.getDto(dominio);
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
	
	/* (non-Javadoc)
	 * @see co.com.ias.pruebatecnica.ws.service.impl.ServiceImpl#create(java.util.List)
	 */
	@Override
	public void create(List<AvesPaisDto> avesPaisDtos){
		AveDto aveDto = avesPaisDtos.get(0).getAveDto();
		iAveService.create(aveDto);
		for (AvesPaisDto avesPaisDto : avesPaisDtos) {
			this.create(avesPaisDto);
		}
	}
}
