package com.projecto.libreria.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projecto.libreria.dao.TipoObraDao;
import com.projecto.libreria.entity.TipoObra;

@Service
public class TipoObraServiceImpl implements TipoObraService{

	@Autowired
	private TipoObraDao tipoObraDAO;
	
	@Override
	public List<TipoObra> listAll() {
		// TODO Auto-generated method stub
		return tipoObraDAO.listAll();
	}

	
}
