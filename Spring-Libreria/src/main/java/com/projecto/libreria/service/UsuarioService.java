package com.projecto.libreria.service;
import java.util.List;
import com.projecto.libreria.entity.Enlace;
import com.projecto.libreria.entity.Usuario;

public interface UsuarioService {
	public Usuario iniciarSesion(String vLogin);
	public List<Enlace> traerEnlaces(int idRol);
	
	
}
