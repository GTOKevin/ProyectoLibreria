package com.projecto.libreria.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.projecto.libreria.entity.Pedido;
import com.projecto.libreria.entity.ObraHasPedido;
import com.projecto.libreria.entity.ObraHasPedidoPK;

@Repository
public class PedidoDAOImpl implements PedidoDAO{
	@Autowired
	private SessionFactory factory;
	
	@Transactional
	@Override
	public void savePedido(Pedido bean) {
		
		Session session=factory.getCurrentSession();
		try {
			//guardar cabecera
			session.save(bean);
			//guardar detalle
			//bucle
			for(ObraHasPedido ohp: bean.getListaObraHasPedido()) {
				//
				ObraHasPedidoPK pk=new ObraHasPedidoPK();
				pk.setNumeroPedido(bean.getNumeroPedido());
				pk.setCodigoObra(ohp.getObra().getCodObr());
				//enviar llave a mhb
				ohp.setPk(pk);
				session.save(ohp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

}









