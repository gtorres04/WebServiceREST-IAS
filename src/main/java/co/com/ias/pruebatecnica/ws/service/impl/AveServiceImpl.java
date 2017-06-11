/**
 * 
 */
package co.com.ias.pruebatecnica.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ias.pruebatecnica.ws.dao.IAveDao;
import co.com.ias.pruebatecnica.ws.dao.IAvesPaisDao;
import co.com.ias.pruebatecnica.ws.dao.IPaisDao;
import co.com.ias.pruebatecnica.ws.domain.Ave;
import co.com.ias.pruebatecnica.ws.domain.AvesPais;
import co.com.ias.pruebatecnica.ws.domain.Pais;
import co.com.ias.pruebatecnica.ws.dto.AveDto;
import co.com.ias.pruebatecnica.ws.dto.PaisDto;
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

	@Autowired
	private IAvesPaisDao iAvesPaisDao;

	@Autowired
	private IPaisDao iPaisDao;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.ias.pruebatecnica.ws.service.impl.ServiceImpl#create(java.lang.
	 * Object)
	 */
	@Override
	public void create(AveDto object) {
		super.create(object);
		for (PaisDto paisDto : object.getPaises()) {
			AvesPais avesPais = new AvesPais();
			avesPais.setIdAve(AveDto.getDomain(object).getCodigo());
			avesPais.setIdPais(PaisDto.getDomain(paisDto).getCodigo());
			iAvesPaisDao.create(avesPais);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.ias.pruebatecnica.ws.service.impl.ServiceImpl#findById(java.lang.
	 * Object)
	 */
	@Override
	public AveDto findById(AveDto object) {
		AveDto aveDto;
		Ave ave = this.iDaoGeneric.findById(AveDto.getDomain(object));
		List<AvesPais> avesPais = this.iAvesPaisDao.findByAve(ave);
		aveDto = AveDto.getDto(ave);
		if (null != avesPais) {
			aveDto.setPaises(new ArrayList<PaisDto>());
			for (AvesPais avePais : avesPais) {
				Pais pais = new Pais();
				pais.setCodigo(avePais.getIdPais());
				pais = iPaisDao.findById(pais);
				aveDto.getPaises().add(PaisDto.getDto(pais));
			}
			aveDto.setPaises(aveDto.getPaises().isEmpty() ? null : aveDto.getPaises());
		}
		return aveDto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.ias.pruebatecnica.ws.service.impl.ServiceImpl#update(java.lang.
	 * Object)
	 */
	@Override
	public void update(AveDto object) {
		Ave ave = AveDto.getDomain(object);
		delete(object);
		this.iDaoGeneric.create(ave);
		if (null != object.getPaises()) {
			for (PaisDto paisDto : object.getPaises()) {
				AvesPais avesPaisAux = new AvesPais();
				avesPaisAux.setIdAve(ave.getCodigo());
				avesPaisAux.setIdPais(paisDto.getCodigo());
				iAvesPaisDao.create(avesPaisAux);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see co.com.ias.pruebatecnica.ws.service.impl.ServiceImpl#delete(java.lang.Object)
	 */
	@Override
	public void delete(AveDto object) {
		Ave ave = this.iDaoGeneric.findById(AveDto.getDomain(object));
		List<AvesPais> avesPais = this.iAvesPaisDao.findByAve(ave);
		if (null != avesPais) {
			iAvesPaisDao.delete(avesPais);
			this.iDaoGeneric.delete(ave);
		}
	}
}
