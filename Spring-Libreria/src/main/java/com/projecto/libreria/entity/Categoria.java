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
@Table(name="tb_categoria")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM categoria c")
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_categoria")
	private int codCategoria;

	@Column(name="nombre")
	private String nomCategoria;
	
	@ManyToOne
	@JoinColumn(name="cod_sub_categoria")
	private Sub_categoria tbSubCate;
	
	@OneToMany(mappedBy="tbCategoria")

	@JsonIgnore
	private List<Producto> tbProducto;

	public int getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getNomCategoria() {
		return nomCategoria;
	}

	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}

	public Sub_categoria getTbSubCate() {
		return tbSubCate;
	}

	public void setTbSubCate(Sub_categoria tbSubCate) {
		this.tbSubCate = tbSubCate;
	}

	public List<Producto> getTbProducto() {
		return tbProducto;
	}

	public void setTbProducto(List<Producto> tbProducto) {
		this.tbProducto = tbProducto;
	}
	
	

}
