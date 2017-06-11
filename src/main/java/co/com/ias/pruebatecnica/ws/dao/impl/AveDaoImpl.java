/**
 * 
 */
package co.com.ias.pruebatecnica.ws.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.ias.pruebatecnica.ws.dao.IAveDao;
import co.com.ias.pruebatecnica.ws.domain.Ave;
import co.com.ias.pruebatecnica.ws.domain.Zona;

/**
 * 
 * @author gtorress
 *
 */
@Repository("AveDaoImpl")
public class AveDaoImpl extends ADaoGenericImpl<Ave> implements IAveDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.ias.pruebatecnica.ws.dao.IAveDao#consultarAvesPorNombresYZona(java
	 * .lang.String, co.com.ias.pruebatecnica.ws.domain.Zona)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public List<Ave> consultarAvesPorNombresYZona(String patronNombre, Zona zona) {
		List<Ave> aves;
		StringBuilder hql = new StringBuilder("SELECT ave FROM Ave ave, AvesPais ap WHERE ave = ap.ave");
		if (null != patronNombre)
			hql.append(" AND (ave.nombreComun = :patronNombre OR ave.nombreCientifico = :patronNombre)");
		if (null != zona)
			hql.append(" AND ap.pais.zona= :zona)");
		Query query = super.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		if (null != patronNombre)
			query.setParameter("patronNombre", patronNombre);
		if (null != zona)
			query.setParameter("zona", zona);
		aves = query.list().isEmpty() ? null : query.list();
		return aves;
	}

}
