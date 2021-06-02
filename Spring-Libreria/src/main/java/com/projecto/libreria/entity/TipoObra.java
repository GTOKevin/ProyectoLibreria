package com.projecto.libreria.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name="tb_tipo_obra")
@NamedQuery(name="TipoObra.findAll", query="SELECT l FROM TipoObra l")
public class TipoObra implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_tipo")
	private int codTipo;

	@Column(name="nom_tipo")
	private String nomTipo;
	
	//bi-directional many-to-one association to Medicamento
	@OneToMany(mappedBy="tbTipoObra")
	//omitir el JSON del atributo "tbMedicamentos"
	@JsonIgnore
	private List<Obra> tbObras;


	public int getCodTipo() {
		return codTipo;
	}

	public void setCodTipo(int codTipo) {
		this.codTipo = codTipo;
	}

	public String getNomTipo() {
		return nomTipo;
	}

	public void setNomTipo(String nomTipo) {
		this.nomTipo = nomTipo;
	}

	public List<Obra> getTbObras() {
		return tbObras;
	}

	public void setTbObras(List<Obra> tbObras) {
		this.tbObras = tbObras;
	}

	
	
}
