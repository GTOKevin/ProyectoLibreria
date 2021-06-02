package com.projecto.libreria.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecto.libreria.dao.ObraDao;
import com.projecto.libreria.entity.Obra;

@Service
public class ObraServiceImpl implements ObraService{

	
	@Autowired
	private ObraDao obraDAO;
	
	
	@Override
	public void save(Obra bean) {
		obraDAO.save(bean);
		
	}

	@Override
	public void update(Obra bean) {
		obraDAO.update(bean);
		
	}

	@Override
	public void delete(int cod) {
		obraDAO.delete(cod);
		
	}

	@Override
	public Obra find(int cod) {
		// TODO Auto-generated method stub
		return obraDAO.find(cod);
	}

	@Override
	public List<Obra> list() {
		// TODO Auto-generated method stub
		return obraDAO.list();
	}
}
