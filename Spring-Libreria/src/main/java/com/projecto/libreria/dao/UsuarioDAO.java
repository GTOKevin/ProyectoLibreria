package com.projecto.libreria.dao;
import java.util.List;
import com.projecto.libreria.entity.Enlace;
import com.projecto.libreria.entity.Usuario;

public interface UsuarioDAO {
	public Usuario iniciarSesion(String vLogin);
	public List<Enlace> traerEnlaces(int idRol);
	
	
}
