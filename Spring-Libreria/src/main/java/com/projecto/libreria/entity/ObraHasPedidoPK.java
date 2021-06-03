package com.projecto.libreria.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ObraHasPedidoPK implements Serializable{
	
	@Column(name = "num_ped")
	private int numeroPedido;
	@Column(name = "cod_obr")
	private int codigoObra;
	
	public int getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(int numeroBoleta) {
		this.numeroPedido = numeroPedido;
	}
	public int getCodigoObra() {
		return codigoObra;
	}
	public void setCodigoObra(int codObr) {
		this.codigoObra = codigoObra;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoObra;
		result = prime * result + numeroPedido;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObraHasPedidoPK other = (ObraHasPedidoPK) obj;
		if (codigoObra != other.codigoObra)
			return false;
		if (numeroPedido != other.numeroPedido)
			return false;
		return true;
	}
	
	
}
