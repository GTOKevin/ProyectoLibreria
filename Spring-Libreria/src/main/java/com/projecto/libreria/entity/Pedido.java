package com.projecto.libreria.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_pedido")

public class Pedido implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num_ped")
	private int numeroPedido;
	@Temporal(TemporalType.DATE)
	@Column(name = "fec_emi_ped")
	private Date fechaEmision;
	@Column(name = "monto_ped")
	private double monto;
	
	//Relación MUCHOS a UNO "Usuario"
	@ManyToOne
	@JoinColumn(name = "cod_usu")
	private Usuario usuario;
		
	//Relación UNO a MUCHOS "ConceptoHasBoleta"
	@OneToMany(mappedBy = "pedido")
	private List<ObraHasPedido> listaObraHasPedido;

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ObraHasPedido> getListaObraHasPedido() {
		return listaObraHasPedido;
	}

	public void setListaObraHasPedido(List<ObraHasPedido> listaObraHasPedido) {
		this.listaObraHasPedido = listaObraHasPedido;
	}
	
	

	
}
