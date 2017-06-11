/**
 * 
 */
package co.com.ias.pruebatecnica.ws.dao.impl;

import java.util.List;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import co.com.ias.pruebatecnica.ws.dao.exception.DaoGenericException;
import co.com.ias.pruebatecnica.ws.support.AdmonLogger;
import co.com.ias.pruebatecnica.ws.support.Enumeraciones;

import org.apache.log4j.Logger;

/**
 * @author gerlin.torres
 *
 * @param <T>
 */

public abstract class ADaoGenericImpl<T> extends ADaoGenericImplTransaccional<T> {

	/**
	 * instancia logger
	 */
	private static final AdmonLogger LOGGER = AdmonLogger.getInstance(Logger.getLogger(ADaoGenericImpl.class));

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#create(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(T object) {
		try {
			super.create(object);
		} catch (GenericJDBCException e) {
			LOGGER.warn(e);
			throw new DaoGenericException(e);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new DaoGenericException(Enumeraciones.MSN_EXCEPTION_DAO.MSN_ERROR_NO_GESTIONADO.getMensaje(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.egoveris.vuce.cupos.core.dao.impl.ADaoGenericImplTransaccional#create
	 * (java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(List<T> object) {
		for (T t : object) {
			this.create(t);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#update(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void update(T object) {
		try {
			super.update(object);
		} catch (GenericJDBCException e) {
			LOGGER.warn(e);
			throw new DaoGenericException(e);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new DaoGenericException(Enumeraciones.MSN_EXCEPTION_DAO.MSN_ERROR_NO_GESTIONADO.getMensaje(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#delete(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(T object) {
		T objectAux;
		objectAux = this.findById(object);
		super.delete(objectAux);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.egoveris.vuce.cupos.core.dao.IDaoGeneric#delete(java.util.List)
	 */
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(List<T> object) {
		for (T t : object) {
			delete(t);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#findById(java.lang.Object)
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public T findById(T object) {
		return super.findById(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#findAll(java.lang.Class)
	 */

	@Override
	@SuppressWarnings({ "rawtypes" })
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<T> findAll(Class clase) {
		return super.findAll(clase);
	}

}
