package com.projecto.libreria.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projecto.libreria.entity.Autor;
import com.projecto.libreria.service.AutorService;

@Controller
@RequestMapping(value = "/autor")
public class AutorController {
	
	@Autowired
	private AutorService autorService;
	

	@RequestMapping(value = "/")
	public String index(Model model) {
		try {
			
			model.addAttribute("autores",autorService.listAll());
			
			model.addAttribute("autor",new Autor());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "autor";
	}
	
	@RequestMapping(value = "/guardar")
	public String guardar(@ModelAttribute Autor autor,RedirectAttributes redirect) {
		try {
			
			if(autor.getCodAutr()==0) {
				autorService.save(autor);
		
				redirect.addFlashAttribute("MENSAJE","Autor guardada");
			}
			else {
				autorService.update(autor);
				//mensaje
				redirect.addFlashAttribute("MENSAJE","Autor actualizada");
			}
				
				
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","Error al guardar");
		}
		return "redirect:/autor/";
	}
	
	@RequestMapping(value = "/buscarAutor")
	@ResponseBody
	public Autor buscarAutor(@RequestParam("codAutor") int cod) {
		Autor obr=null;
		try {
			obr=autorService.find(cod);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obr;
	}
	
	@RequestMapping(value = "/eliminarAutor")
	public String eliminar(@RequestParam("codAutor") int cod,RedirectAttributes redirect) {
		try {
			autorService.delete(cod);
			redirect.addFlashAttribute("MENSAJE","Autor eliminado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/autor/";
	}

}
