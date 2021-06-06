package com.projecto.libreria.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="tb_marca")
@NamedQuery(name="Marca.findAll", query="SELECT m FROM marca m")
public class Marca implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_marca")
	private int codMar;

	@Column(name="nombre")
	private String nomMarca;
	
	
	
	@OneToMany(mappedBy="tbMarca")

	@JsonIgnore
	private List<Item_sc> tbItem;



	public int getCodMar() {
		return codMar;
	}



	public void setCodMar(int codMar) {
		this.codMar = codMar;
	}



	public String getNomMarca() {
		return nomMarca;
	}



	public void setNomMarca(String nomMarca) {
		this.nomMarca = nomMarca;
	}



	public List<Item_sc> getTbItem() {
		return tbItem;
	}



	public void setTbItem(List<Item_sc> tbItem) {
		this.tbItem = tbItem;
	}


	


	
	
	

}
