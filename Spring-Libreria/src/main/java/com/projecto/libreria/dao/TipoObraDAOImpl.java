package com.projecto.libreria.dao;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projecto.libreria.entity.TipoObra;

@Repository
public class TipoObraDAOImpl implements TipoObraDao{
	@Autowired
	private SessionFactory factory;
	
	@Transactional(readOnly = true)
	@Override
	public List<TipoObra> listAll() {
		Session session=factory.getCurrentSession();
		Query query=null;
		try {
			String hql="select tp from TipoObra tp";
			query=session.createQuery(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
	
}
