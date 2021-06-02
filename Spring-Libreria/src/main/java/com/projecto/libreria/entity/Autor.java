package com.projecto.libreria.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name="tb_autor")
@NamedQuery(name="Autor.findAll", query="SELECT l FROM Autor l")
public class Autor implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_aut")
	private int codAutr;

	@Column(name="nom_aut")
	private String nomAutr;
	
	@Column(name="dir_aut")
	private String dirAutr;
	
	//bi-directional many-to-one association to Medicamento
	@OneToMany(mappedBy="tbAutor")
	//omitir el JSON del atributo "tbMedicamentos"
	@JsonIgnore
	private List<Obra> tbObras;

	
	public int getCodAutr() {
		return codAutr;
	}

	public void setCodAutr(int codAutr) {
		this.codAutr = codAutr;
	}

	public String getNomAutr() {
		return nomAutr;
	}

	public void setNomAutr(String nomAutr) {
		this.nomAutr = nomAutr;
	}

	public String getDirAutr() {
		return dirAutr;
	}

	public void setDirAutr(String dirAutr) {
		this.dirAutr = dirAutr;
	}

	public List<Obra> getTbObras() {
		return tbObras;
	}

	public void setTbObras(List<Obra> tbObras) {
		this.tbObras = tbObras;
	}
	
	
	
	
}
