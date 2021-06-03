package com.projecto.libreria.dao;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projecto.libreria.entity.Autor;
import com.projecto.libreria.entity.Obra;

@Repository
public class AutorDaoImpl implements AutorDao{

	@Autowired
	private SessionFactory factory;
	
	@Transactional(readOnly = true)
	@Override
	public List<Autor> listAll() {
		Session session=factory.getCurrentSession();
		Query query=null;
		try {
			String hql="select a from Autor a";
			query=session.createQuery(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Transactional
	@Override
	public void save(Autor bean) {
		//crear un objeto de la clase Session para gestionar una sesión de la conexíon "factory"
		Session session=factory.getCurrentSession();
		try {
			session.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	@Override
	public void update(Autor bean) {
		Session session=factory.getCurrentSession();
		try {
			session.update(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Transactional
	@Override
	public void delete(int cod) {
		Session session=factory.getCurrentSession();
		try {
			//buscar el Medicamento según "cod"
			Autor bean=session.get(Autor.class, cod);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Transactional(readOnly = true)
	@Override
	public Autor find(int cod) {
		Session session=factory.getCurrentSession();
		Autor bean=null;
		try {
			//buscar la Obra según "cod"
			bean=session.get(Autor.class, cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
}
