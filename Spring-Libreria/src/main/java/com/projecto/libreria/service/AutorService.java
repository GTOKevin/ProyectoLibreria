package com.projecto.libreria.service;
import java.util.List;

import com.projecto.libreria.entity.Autor;
import com.projecto.libreria.entity.Obra;

public interface AutorService {

	public List<Autor> listAll();
	public void save(Autor bean);
	public void update(Autor bean);
	public void delete(int cod);
	public Autor find(int cod);
}
