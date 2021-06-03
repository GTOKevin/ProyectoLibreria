package com.projecto.libreria.servicio;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projecto.libreria.dao.UsuarioDAO;
import com.projecto.libreria.entity.Usuario;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDet=null;
		
		Usuario bean;
		bean=usuarioDAO.iniciarSesion(username);	
		
		Set<GrantedAuthority> rol=new HashSet<GrantedAuthority>();
		rol.add(new SimpleGrantedAuthority(bean.getRol().getDescripcion()));
		
		userDet=new User(bean.getLogin(), bean.getPassword(),rol);
		//bean.getRol().getDescripcion()
		
		
		return userDet;
	}

	
	
}
