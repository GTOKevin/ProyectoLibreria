package com.projecto.libreria.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rol_enlace database table.
 * 
 */
@Embeddable
public class RolEnlacePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idrol;

	private int idenlace;

	
	
	
	
	
	public RolEnlacePK() {
	}
	public int getIdrol() {
		return this.idrol;
	}
	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}
	public int getIdenlace() {
		return this.idenlace;
	}
	public void setIdenlace(int idenlace) {
		this.idenlace = idenlace;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RolEnlacePK)) {
			return false;
		}
		RolEnlacePK castOther = (RolEnlacePK)other;
		return 
			(this.idrol == castOther.idrol)
			&& (this.idenlace == castOther.idenlace);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idrol;
		hash = hash * prime + this.idenlace;
		
		return hash;
	}
}