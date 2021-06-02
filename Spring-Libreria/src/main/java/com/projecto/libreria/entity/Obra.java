package com.projecto.libreria.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="tb_Obra")
@NamedQuery(name="Obra.findAll", query="SELECT o FROM Obra o")
public class Obra implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_obr")
	private int codObr;

	@Column(name="nom_obr")
	private String nomObr;

	@Column(name="des_obr")
	private String desObr;
	
	@Column(name="sto_obr")
	private int stoObr;
	
	@Column(name="pre_Obr")
	private double preObr;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_publi_obr")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date fecPubObr;
	
	@ManyToOne
	@JoinColumn(name="cod_tipo")
	private TipoObra tbTipoObra;

	
	@ManyToOne
	@JoinColumn(name="cod_aut")
	private Autor tbAutor;

	
	public Obra() {
	}

	public int getCodObr() {
		return codObr;
	}


	public void setCodObr(int codObr) {
		this.codObr = codObr;
	}


	public String getNomObr() {
		return nomObr;
	}


	public void setNomObr(String nomObr) {
		this.nomObr = nomObr;
	}


	public String getDesObr() {
		return desObr;
	}


	public void setDesObr(String desObr) {
		this.desObr = desObr;
	}


	public int getStoObr() {
		return stoObr;
	}


	public void setStoObr(int stoObr) {
		this.stoObr = stoObr;
	}


	public double getPreObr() {
		return preObr;
	}


	public void setPreObr(double preObr) {
		this.preObr = preObr;
	}


	public Date getFecPubObr() {
		return fecPubObr;
	}


	public void setFecPubObr(Date fecPubObr) {
		this.fecPubObr = fecPubObr;
	}


	public TipoObra getTbTipoObra() {
		return tbTipoObra;
	}


	public void setTbTipoObra(TipoObra tbTipoObra) {
		this.tbTipoObra = tbTipoObra;
	}


	public Autor getTbAutor() {
		return tbAutor;
	}


	public void setTbAutor(Autor tbAutor) {
		this.tbAutor = tbAutor;
	}

	
	
	
	//bi-directional many-to-one association to TipoMedicamento
	

	
	//@OneToMany(mappedBy = "medicamento")
	//private List<MedicamentoHasBoleta> listaMedicamentoHasBoleta;
	
	
}
