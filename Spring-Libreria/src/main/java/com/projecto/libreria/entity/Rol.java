package com.projecto.libreria.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@Table(name="tb_rol")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idrol;

	private String descripcion;

	@OneToMany(mappedBy="rol")
	private List<RolEnlace> rolenlaces;
	
	@OneToMany(mappedBy="rol")
	private List<Usuario> listaUsuario;
	
	public Rol() {
	}

	public int getIdrol() {
		return this.idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<RolEnlace> getRolenlaces() {
		return rolenlaces;
	}

	public void setRolenlaces(List<RolEnlace> rolenlaces) {
		this.rolenlaces = rolenlaces;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	

}