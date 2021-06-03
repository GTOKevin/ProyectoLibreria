package com.projecto.libreria.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.projecto.libreria.dao.AutorDao;
import com.projecto.libreria.entity.Autor;
import com.projecto.libreria.entity.Obra;

@Service
public class AutorServiceImpl implements AutorService{

	@Autowired
	private AutorDao autorDAO;
	
	@Override
	public List<Autor> listAll() {
		// TODO Auto-generated method stub
		return autorDAO.listAll();
	}
	
	@Override
	public void save(Autor bean) {
		autorDAO.save(bean);
		
	}
	@Override
	public void update(Autor bean) {
		autorDAO.update(bean);
		
	}

	@Override
	public void delete(int cod) {
		autorDAO.delete(cod);
		
	}

	@Override
	public Autor find(int cod) {
		// TODO Auto-generated method stub
		return autorDAO.find(cod);
	}

	
	
}
