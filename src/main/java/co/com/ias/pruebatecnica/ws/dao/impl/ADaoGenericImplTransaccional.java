/**
 * 
 */
package co.com.ias.pruebatecnica.ws.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.ias.pruebatecnica.ws.dao.IDaoGeneric;
import co.com.ias.pruebatecnica.ws.dao.exception.DaoGenericException;
import co.com.ias.pruebatecnica.ws.support.AdmonLogger;
import co.com.ias.pruebatecnica.ws.support.Utilidades;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 * @author gerlin.torres
 *
 * @param <T>
 */
public abstract class ADaoGenericImplTransaccional<T> implements IDaoGeneric<T> {

	/**
	 * 
	 */
	private static final AdmonLogger LOGGER = AdmonLogger
			.getInstance(Logger.getLogger(ADaoGenericImplTransaccional.class));

	/**
	 * 
	 */
	@Autowired
	@Qualifier("mySessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * @return
	 */
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#create(java.lang.Object)
	 */

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(T object){
		sessionFactory.getCurrentSession().save(object);
		sessionFactory.getCurrentSession().flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#update(java.lang.Object)
	 */

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void update(T object){
		sessionFactory.getCurrentSession().merge(object);
		sessionFactory.getCurrentSession().flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#delete(java.lang.Object)
	 */
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(T object){
		sessionFactory.getCurrentSession().delete(object);
		sessionFactory.getCurrentSession().flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#findById(java.lang.Object)
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public T findById(T object){
		Class claseGenerica = object.getClass();
		Method metodoGetId;
		T objectAux = null;
		try {
			metodoGetId = claseGenerica.getMethod("getId");
			objectAux = (T) sessionFactory.getCurrentSession().get(claseGenerica, (long) metodoGetId.invoke(object));
		} catch (HibernateException | InvocationTargetException | SecurityException | NoSuchMethodException
				| IllegalAccessException | IllegalArgumentException e) {
			LOGGER.error(e);
			throw new DaoGenericException(e);
		}
		return objectAux;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.g2eo.softventory.dao.core.Dao#findAll(java.lang.Class)
	 */

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<T> findAll(Class clase){
		List<T> listado;
		Query query = sessionFactory.getCurrentSession().createQuery("from " + clase.getName());
		listado = query.list();
		listado = Utilidades.eliminarObjetosNulos((List<Object>) listado);
		listado = listado.isEmpty() ? null : listado;
		return listado;
	}
}
