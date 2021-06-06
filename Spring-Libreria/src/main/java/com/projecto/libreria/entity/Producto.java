package com.projecto.libreria.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_producto")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM producto p")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_producto")
	private int codProducto;

	@Column(name="descripcion")
	private String desc;
	
	@Column(name="precio")
	private double prec;
	
	@Column(name="cantidad")
	private int cant;
	
	@ManyToOne
	@JoinColumn(name="cod_categoria")
	private Categoria tbCategoria;
	
	@ManyToOne
	@JoinColumn(name="cod_marca")
	private Marca tbMarca;

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrec() {
		return prec;
	}

	public void setPrec(double prec) {
		this.prec = prec;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public Categoria getTbCategoria() {
		return tbCategoria;
	}

	public void setTbCategoria(Categoria tbCategoria) {
		this.tbCategoria = tbCategoria;
	}

	public Marca getTbMarca() {
		return tbMarca;
	}

	public void setTbMarca(Marca tbMarca) {
		this.tbMarca = tbMarca;
	}
	
	


}
