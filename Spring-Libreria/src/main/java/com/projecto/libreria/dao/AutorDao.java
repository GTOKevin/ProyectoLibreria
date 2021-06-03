package com.projecto.libreria.dao;
import java.util.List;

import com.projecto.libreria.entity.Autor;
import com.projecto.libreria.entity.Obra;
public interface AutorDao {
	public void save(Autor bean);
	public void update(Autor bean);
	public void delete(int cod);
	public Autor find(int cod);
	public List<Autor> listAll();

}
