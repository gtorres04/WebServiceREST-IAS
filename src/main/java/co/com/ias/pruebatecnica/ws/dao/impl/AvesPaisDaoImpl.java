/**
 * 
 */
package co.com.ias.pruebatecnica.ws.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import co.com.ias.pruebatecnica.ws.dao.IAvesPaisDao;
import co.com.ias.pruebatecnica.ws.domain.Ave;
import co.com.ias.pruebatecnica.ws.domain.AvesPais;

/**
 * 
 * @author gtorress
 *
 */
@Repository("AvesPaisDaoImpl")
public class AvesPaisDaoImpl extends ADaoGenericImpl<AvesPais> implements IAvesPaisDao {
	
	/* (non-Javadoc)
	 * @see co.com.ias.pruebatecnica.ws.dao.IAvesPaisDao#findByAve(co.com.ias.pruebatecnica.ws.domain.Ave)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AvesPais> findByAve(Ave ave){
		List<AvesPais> avesPais;
		StringBuilder hql = new StringBuilder("FROM AvesPais ap WHERE 1=1");
		if (null != ave)
			hql.append(" AND ap.idAve = :idAve");
		Query query = super.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		if (null != ave)
			query.setParameter("idAve", ave.getCodigo());
		avesPais = query.list().isEmpty() ? null : query.list();
		return avesPais;
	}
}
