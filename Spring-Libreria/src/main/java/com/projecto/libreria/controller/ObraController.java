package com.projecto.libreria.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projecto.libreria.entity.Autor;
import com.projecto.libreria.entity.Obra;
import com.projecto.libreria.entity.TipoObra;
import com.projecto.libreria.service.AutorService;
import com.projecto.libreria.service.ObraService;
import com.projecto.libreria.service.TipoObraService;

@Controller
@RequestMapping(value = "/obra")
public class ObraController {	

	@Autowired
	private ObraService obraService;
	
	@Autowired
	private TipoObraService tipoObraService;
	
	@Autowired
	private AutorService autorService;
	
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		try {
			//enviar atributo a la página "obra.html"
			model.addAttribute("obras",obraService.list());
			model.addAttribute("tipoObras",tipoObraService.listAll());
			model.addAttribute("autores",autorService.listAll());
			
			model.addAttribute("obra",new Obra());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "obra";
	}
	
	@RequestMapping(value = "/guardar")
	public String guardar(@ModelAttribute Obra obra,@RequestParam("tipo") int codTipo,@RequestParam("autor") int codAutor,
							@RequestParam("fecha") String fecha,RedirectAttributes redirect) {
		try {
			//crear un objeto de la clase Tipo Obra
			TipoObra tp=new TipoObra();
			tp.setCodTipo(codTipo);
			//enviar objeto "tp" al objeto "obra"
			obra.setTbTipoObra(tp);
			//
			
			//crear un objeto de la clase Tipo Obra
			Autor at=new Autor();
			at.setCodAutr(codAutor);
			//enviar objeto "tp" al objeto "obra"
			obra.setTbAutor(at);
			
			
			SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
			Date fec=sd.parse(fecha);
			obra.setFecPubObr(fec);
			//validar código
			if(obra.getCodObr()==0) {
				obraService.save(obra);
				//mensaje
				redirect.addFlashAttribute("MENSAJE","Obra guardada");
			}
			else {
				obraService.update(obra);
				//mensaje
				redirect.addFlashAttribute("MENSAJE","Obra actualizada");
			}
				
				
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","Error al guardar");
		}
		return "redirect:/obra/";
	}
	
	
	@RequestMapping(value = "/buscarObra")
	@ResponseBody
	public Obra buscarObrao(@RequestParam("codObra") int cod) {
		Obra obr=null;
		try {
			obr=obraService.find(cod);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obr;
	}
	
	@RequestMapping(value = "/eliminarObra")
	public String eliminar(@RequestParam("codObra") int cod,RedirectAttributes redirect) {
		try {
			obraService.delete(cod);
			redirect.addFlashAttribute("MENSAJE","Medicamento eliminado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/obra/";
	}
}
