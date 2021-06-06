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
@Table(name="tb_sub_categoria")
@NamedQuery(name="Sub_categoria.findAll", query="SELECT s FROM sub_categoria s")
public class Sub_categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_sub_categoria")
	private int codSubcate;

	@Column(name="nombre")
	private String nomSubcategoria;
	
	@ManyToOne
	@JoinColumn(name="cod_iten_sc")
	private Item_sc tbItem;
	
	@OneToMany(mappedBy="tbSubCate")

	@JsonIgnore
	private List<Categoria> tbCategoria;

	public int getCodSubcate() {
		return codSubcate;
	}

	public void setCodSubcate(int codSubcate) {
		this.codSubcate = codSubcate;
	}

	public String getNomSubcategoria() {
		return nomSubcategoria;
	}

	public void setNomSubcategoria(String nomSubcategoria) {
		this.nomSubcategoria = nomSubcategoria;
	}

	public Item_sc getTbItem() {
		return tbItem;
	}

	public void setTbItem(Item_sc tbItem) {
		this.tbItem = tbItem;
	}

	public List<Categoria> getTbCategoria() {
		return tbCategoria;
	}

	public void setTbCategoria(List<Categoria> tbCategoria) {
		this.tbCategoria = tbCategoria;
	}
	
	



	
	

}
