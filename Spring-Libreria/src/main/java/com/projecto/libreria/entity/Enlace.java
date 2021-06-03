package com.projecto.libreria.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the enlace database table.
 * 
 */
@Entity
@Table(name="tb_enlace")
@NamedQuery(name="Enlace.findAll", query="SELECT e FROM Enlace e")
public class Enlace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idenlace;

	private String descripcion;

	private String ruta;
	
	@OneToMany(mappedBy="enlace")
	private List<RolEnlace>rolEnlace;
	
	
	public Enlace() {
	}

	public int getIdenlace() {
		return this.idenlace;
	}

	public void setIdenlace(int idenlace) {
		this.idenlace = idenlace;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRuta() {
		return this.ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}