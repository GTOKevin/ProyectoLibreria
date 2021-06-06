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
@Table(name="tb_item_sc")
@NamedQuery(name="Item_sc.findAll", query="SELECT i FROM item_sc i")
public class Item_sc  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_item_sc")
	private int codItemsc;

	@Column(name="nombre")
	private String nomItem;
	
	@ManyToOne
	@JoinColumn(name="cod_marca")
	private Marca tbMarca;
	
	@OneToMany(mappedBy="tbItem")

	@JsonIgnore
	private List<Sub_categoria> tbSubcategoria;

	public int getCodItemsc() {
		return codItemsc;
	}

	public void setCodItemsc(int codItemsc) {
		this.codItemsc = codItemsc;
	}

	public String getNomItem() {
		return nomItem;
	}

	public void setNomItem(String nomItem) {
		this.nomItem = nomItem;
	}

	public Marca getTbMarca() {
		return tbMarca;
	}

	public void setTbMarca(Marca tbMarca) {
		this.tbMarca = tbMarca;
	}

	public List<Sub_categoria> getTbSubcategoria() {
		return tbSubcategoria;
	}

	public void setTbSubcategoria(List<Sub_categoria> tbSubcategoria) {
		this.tbSubcategoria = tbSubcategoria;
	}
	
	

}
