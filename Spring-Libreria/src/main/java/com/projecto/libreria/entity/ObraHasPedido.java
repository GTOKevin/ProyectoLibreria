package com.projecto.libreria.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_obra_has_pedido")
public class ObraHasPedido implements Serializable{
	@EmbeddedId
	private ObraHasPedidoPK pk;
	
	
	//Relación MUCHOS  a UNO "Obra"
	@ManyToOne
	@JoinColumn(name="cod_obr",referencedColumnName = "cod_obr",insertable = false,updatable =false)
	private Obra obra;//ASOCI.
	
	//Relación MUCHOS  a UNO "Pedido"
	@ManyToOne
	@JoinColumn(name="num_ped",referencedColumnName = "num_ped",insertable = false,updatable =false)
	private Pedido pedido;//ASOCI.
	
	@Column(name = "pre")
	private double precio;

	public ObraHasPedidoPK getPk() {
		return pk;
	}

	public void setPk(ObraHasPedidoPK pk) {
		this.pk = pk;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	
}
