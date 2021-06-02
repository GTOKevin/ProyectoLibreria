package com.projecto.libreria.dao;
import java.util.List;
import com.projecto.libreria.entity.Obra;


public interface ObraDao {
	public void save(Obra bean);
	public void update(Obra bean);
	public void delete(int cod);
	public Obra find(int cod);
	public List<Obra> list();
}
