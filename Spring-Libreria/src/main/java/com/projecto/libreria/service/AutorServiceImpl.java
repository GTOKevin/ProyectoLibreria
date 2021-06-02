package com.projecto.libreria.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.projecto.libreria.dao.AutorDao;
import com.projecto.libreria.entity.Autor;

@Service
public class AutorServiceImpl implements AutorService{

	@Autowired
	private AutorDao autorDAO;
	
	@Override
	public List<Autor> listAll() {
		// TODO Auto-generated method stub
		return autorDAO.listAll();
	}

	
}
