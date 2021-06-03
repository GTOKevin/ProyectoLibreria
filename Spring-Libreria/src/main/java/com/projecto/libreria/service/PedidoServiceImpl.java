package com.projecto.libreria.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecto.libreria.dao.PedidoDAO;
import com.projecto.libreria.entity.Pedido;

@Service
public class PedidoServiceImpl implements PedidoService{
	@Autowired
	private PedidoDAO boletaDAO;
	
	@Override
	public void savePedido(Pedido bean) {
		boletaDAO.savePedido(bean);
		
	}

}
