package com.projecto.libreria.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projecto.libreria.entity.Enlace;
import com.projecto.libreria.entity.Usuario;
import com.projecto.libreria.service.UsuarioService;

@Controller
public class UsuarioController {
	
	
	@RequestMapping(value = "/login")
	public String login() {

		
		return "login";
	}
	
	@RequestMapping(value = "/menu")
	public String menu() {

		
		return "menu";
	}
	
	@RequestMapping(value = "/requerimiento")
	public String requerimiento() {

		
		return "requerimiento";
	}
	
}
