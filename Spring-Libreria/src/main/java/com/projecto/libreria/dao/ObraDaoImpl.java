package com.projecto.libreria.dao;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projecto.libreria.entity.Obra;

@Repository
public class ObraDaoImpl implements ObraDao{

	
	//atributo de conexión
		@Autowired
		private SessionFactory factory;
		
		@Transactional
		@Override
		public void save(Obra bean) {
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
		public void update(Obra bean) {
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
				Obra bean=session.get(Obra.class, cod);
				session.delete(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		@Transactional(readOnly = true)
		@Override
		public Obra find(int cod) {
			Session session=factory.getCurrentSession();
			Obra bean=null;
			try {
				//buscar la Obra según "cod"
				bean=session.get(Obra.class, cod);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bean;
		}

		@Transactional(readOnly = true)
		@Override
		public List<Obra> list() {
			Session session=factory.getCurrentSession();
			Query query=null;
			try {
				String hql="select o from Obra o";
				query=session.createQuery(hql);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return query.getResultList();
		}
		
}
