/**
 * 
 */
package co.com.ias.pruebatecnica.ws.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import co.com.ias.pruebatecnica.ws.dao.IDaoGeneric;
import co.com.ias.pruebatecnica.ws.dao.exception.DaoGenericException;
import co.com.ias.pruebatecnica.ws.service.IService;
import co.com.ias.pruebatecnica.ws.service.exception.CuposServiceException;
import co.com.ias.pruebatecnica.ws.support.AdmonLogger;

/**
 * @author gtorress
 *
 */
@Transactional
public abstract class ServiceImpl<D, T> implements IService<T> {
	/**
	 * 
	 */
	private static final AdmonLogger LOGGER = AdmonLogger.getInstance(Logger.getLogger(ServiceImpl.class));

	/**
	 * Dependencia Dao Generica
	 */
	protected IDaoGeneric<D> iDaoGeneric;

	/**
	 * Clase del dominio gestionar en el DAO
	 */
	private Class<D> claseDominio;

	/**
	 * @param iDaoGeneric
	 */
	public ServiceImpl(IDaoGeneric<D> iDaoGeneric, Class<D> claseDominio) {
		this.iDaoGeneric = iDaoGeneric;
		this.claseDominio = claseDominio;
	}

	/**
	 * @param claseDominio
	 */
	public ServiceImpl(Class<D> claseDominio) {
		this.claseDominio = claseDominio;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.egoveris.vuce.cupos.core.service.Service#create(java.lang.Object)
	 */
	@Override
	public void create(T object){
		D dominio = null;
		try {
			dominio = getDomainSetted(object);
			iDaoGeneric.create(dominio);
			BeanUtils.copyProperties(dominio, object);
		} catch (DaoGenericException e) {
			LOGGER.debug(e);
			throw new CuposServiceException(e);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new CuposServiceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.egoveris.vuce.cupos.core.service.Service#findById(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T findById(T object){
		T entidad = null;
		D dominio = null;
		try {
			entidad = (T) object.getClass().newInstance();
			dominio = getDomainSetted(object);
			dominio = iDaoGeneric.findById(dominio);
			BeanUtils.copyProperties(dominio, entidad);
		} catch (DaoGenericException e) {
			LOGGER.debug(e);
			throw new CuposServiceException(e);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new CuposServiceException(e);
		}
		return entidad;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.egoveris.vuce.cupos.core.service.Service#findAll()
	 */
	@Override
	public List<T> findAll(Class<T> clase){
		List<T> dtos = null;
		List<D> dominios = null;
		try {
			dominios = iDaoGeneric.findAll(claseDominio);
			if (dominios != null) {
				dtos = new ArrayList<>();
				for (D d : dominios) {
					T dto = clase.newInstance();
					BeanUtils.copyProperties(d, dto);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.egoveris.vuce.cupos.core.service.Service#update(java.lang.Object)
	 */
	@Override
	public void update(T object){
		D dominio = null;
		try {
			dominio = getDomainSetted(object);
			dominio = iDaoGeneric.findById(dominio);
			BeanUtils.copyProperties(object, dominio);
			iDaoGeneric.update(dominio);
		} catch (DaoGenericException e) {
			LOGGER.debug(e);
			throw new CuposServiceException(e);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new CuposServiceException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.egoveris.vuce.cupos.core.service.Service#delete(java.lang.Object)
	 */
	@Override
	public void delete(T object){
		D dominio = null;
		try {
			dominio = getDomainSetted(object);
			dominio=iDaoGeneric.findById(dominio);
			iDaoGeneric.delete(dominio);
		} catch (DaoGenericException e) {
			LOGGER.debug(e);
			throw new CuposServiceException(e);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new CuposServiceException(e);
		}
	}

	/**
	 * Crea una instancia del Dominio y settea sus valores, a partir de un T.
	 * 
	 * @param dto
	 * @return
	 */
	protected D getDomainSetted(T dto){
		D dominio = null;
		try {
			dominio = claseDominio.newInstance();
			BeanUtils.copyProperties(dto, dominio);
			return dominio;
		} catch (InstantiationException | IllegalAccessException e) {
			LOGGER.debug(e);
			throw new CuposServiceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.egoveris.vuce.cupos.core.service.IService#create(java.util.List)
	 */
	@Override
	public void create(List<T> dtos){
		for (T dto : dtos) {
			this.create(dto);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.egoveris.vuce.cupos.core.service.IService#update(java.util.List)
	 */
	@Override
	public void update(List<T> dtos){
		for (T dto : dtos) {
			this.update(dto);
		}
	}
}
