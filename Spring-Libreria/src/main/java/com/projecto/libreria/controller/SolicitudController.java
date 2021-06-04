package com.projecto.libreria.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projecto.libreria.entity.Pedido;
import com.projecto.libreria.entity.Detalle;
import com.projecto.libreria.entity.Obra;
import com.projecto.libreria.entity.ObraHasPedido;
import com.projecto.libreria.entity.Usuario;
import com.projecto.libreria.service.PedidoService;
import com.projecto.libreria.service.ObraService;

@Controller
@RequestMapping(value = "/requerimiento")
public class SolicitudController {
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ObraService obraService;
	
	
	@RequestMapping(value = "/registrar")
	public String registrar() {
		try {
			//CABECERA
			Pedido bean=new Pedido();
			bean.setFechaEmision(new Date());
			bean.setMonto(2000);
			Usuario u=new Usuario();
			u.setCodUsuario(1);
			bean.setUsuario(u);
			
			//DETALLE
			//arreglo de objetos de clase ObraHasPedido
			List<ObraHasPedido> data=new ArrayList<ObraHasPedido>();
			//objeto de la clase ObraHasPedido
			ObraHasPedido ohp=new ObraHasPedido();
			Obra o;
			o=new Obra();
			o.setCodObr(2);
			ohp.setObra(o);
			ohp.setPrecio(555);
			//adicionar "ohp" dentro "data"
			data.add(ohp);
			

			//enviar "data" al objeto "bean" 
			bean.setListaObraHasPedido(data);
			//grabar
			pedidoService.savePedido(bean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "requerimiento";
	}
	
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("obra",obraService.list());
		return "requerimiento";
	}
	
	
	
	@RequestMapping(value = "/adicionar")
	@ResponseBody
	public List<Detalle> adicionar(@RequestParam("codigo")int cod,@RequestParam("nombre") String nom,
							@RequestParam("cantidad")int can,@RequestParam("precio") double pre,
							HttpServletRequest request) {
		
		List<Detalle> lista=null;
		HttpSession session=request.getSession(); 
		if(session.getAttribute("detalle")==null) {
			lista = new ArrayList<Detalle>();
		}
		else {
			lista = (List<Detalle>) session.getAttribute("detalle");
		}
		boolean estado=false;
		for(Detalle d:lista) {
			if(d.getCodigo()==cod) {
				estado=true;
				break;
			}
		}
		if(estado==false) {
			Detalle bean = new Detalle();
			bean.setCodigo(cod);
			bean.setNombre(nom);
			bean.setCantidad(can);
			bean.setPrecio(pre);
			lista.add(bean);
			session.setAttribute("detalle", lista);
		}
		return lista;
		
	}
	
	@RequestMapping(value = "/eliminar")
	@ResponseBody
	public List<Detalle> eliminar(@RequestParam("codigo")int cod,HttpServletRequest request){
		HttpSession session=request.getSession();
		List<Detalle> lista=(List<Detalle>) session.getAttribute("detalle");
		for(Detalle d:lista) {
			if(d.getCodigo()==cod) {
				lista.remove(d);
				break;
			}
		
		}
		session.setAttribute("detalle", lista);
		return lista;
	}
	
}















