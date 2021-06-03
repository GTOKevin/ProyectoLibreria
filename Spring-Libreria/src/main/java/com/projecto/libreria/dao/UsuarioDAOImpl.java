package com.projecto.libreria.dao;
import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.projecto.libreria.entity.Enlace;
import com.projecto.libreria.entity.Usuario;
@Repository
public class UsuarioDAOImpl implements UsuarioDAO{

	@Autowired
	private SessionFactory factory;
	
	@Transactional(readOnly = true)
	@Override
	public Usuario iniciarSesion(String vLogin) {
		Session session=factory.getCurrentSession();
		Usuario bean=null;
		Query query=null;
		try {
			String hql="select u from Usuario u where u.login=?1";
			query=session.createQuery(hql);
			query.setParameter(1, vLogin);
			List<Usuario> lista=query.getResultList();
			if(!lista.isEmpty())
				bean=(Usuario) query.getSingleResult();
			
			//Optional x;//ofnullable
			//bean = (Usuario) Optional.ofNullable(query.getSingleResult()).orElse(new Usuario());
			//Optional.ofnullable(query::getSingleResult).or(new Usuario());
			//bean.length > 0 ? bean: new Usuario


			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Enlace> traerEnlaces(int idRol) {
		Session session=factory.getCurrentSession();
		List<Enlace> lista=null;
		Query query=null;
		try {
			String hql="select e from RolEnlace re join re.enlace e where re.rol.idrol=?1";
			query=session.createQuery(hql);
			query.setParameter(1, idRol);
			lista=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
		
		
		//select re.idenlace, e.descripcion from tb_rol_enlace re 
		//inner join tb_enlace e on re.idenlace = e.idenlace where re.idrol = 1; 
	}

}


