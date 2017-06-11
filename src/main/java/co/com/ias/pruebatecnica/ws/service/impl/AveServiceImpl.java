/**
 * 
 */
package co.com.ias.pruebatecnica.ws.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ias.pruebatecnica.ws.dao.IAveDao;
import co.com.ias.pruebatecnica.ws.domain.Ave;
import co.com.ias.pruebatecnica.ws.dto.AveDto;
import co.com.ias.pruebatecnica.ws.dto.ZonaDto;
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

	private IAveDao iAveDao;

	/**
	 * Dependencia Dao de Ave
	 */

	@Autowired
	public AveServiceImpl(IAveDao iAveDao) {
		super(iAveDao, Ave.class);
		this.iAveDao = iAveDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.ias.pruebatecnica.ws.service.IAveService#
	 * consultarAvesPorNombresYZona(java.lang.String,
	 * co.com.ias.pruebatecnica.ws.dto.ZonaDto)
	 */
	@Override
	public List<AveDto> consultarAvesPorNombresYZona(String patronNombre, ZonaDto zonaDto) {
		String patronNombreValidad = null;
		List<AveDto> aveDtos;
		if (null != patronNombre)
			patronNombreValidad = patronNombre.isEmpty() ? null : patronNombre;
		List<Ave> aves = iAveDao.consultarAvesPorNombresYZona(patronNombreValidad, ZonaDto.getDomain(zonaDto));
		aveDtos = AveDto.getDto(aves);
		return aveDtos;
	}
}
