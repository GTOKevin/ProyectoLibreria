package com.projecto.libreria.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projecto.libreria.dao.UsuarioDAO;
import com.projecto.libreria.entity.Enlace;
import com.projecto.libreria.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	
	@Override
	public Usuario iniciarSesion(String vLogin) {
		// TODO Auto-generated method stub
		return usuarioDAO.iniciarSesion(vLogin);
	}

	@Override
	public List<Enlace> traerEnlaces(int idRol) {
		// TODO Auto-generated method stub
		return usuarioDAO.traerEnlaces(idRol);
	}
	
}
