package com.projecto.libreria.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rol_enlace database table.
 * 
 */
@Entity
@Table(name="tb_rol_enlace")
@NamedQuery(name="RolEnlace.findAll", query="SELECT r FROM RolEnlace r")
public class RolEnlace implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RolEnlacePK id;

	@ManyToOne
	@JoinColumn(name="idenlace",referencedColumnName="idenlace",insertable=false,updatable=false)
	private Enlace enlace;
	@ManyToOne
	@JoinColumn(name="idrol",referencedColumnName="idrol",insertable=false,updatable=false)
	private Rol rol;
	
	public RolEnlace() {
	}

	public RolEnlacePK getId() {
		return this.id;
	}

	public void setId(RolEnlacePK id) {
		this.id = id;
	}

}