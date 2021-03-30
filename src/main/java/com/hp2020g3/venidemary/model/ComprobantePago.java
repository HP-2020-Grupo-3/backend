package com.hp2020g3.venidemary.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="comprobantePago")
public class ComprobantePago {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private Date fecha;
	private Integer numeroComprobante;
	private String numeroFactura;
	private String nota;
	
public ComprobantePago() {}
	
	public ComprobantePago (Integer id, Date fecha, Integer numeroComprobante, String numeroFactura, String nota) {
		this.id = id;
		this.fecha = fecha;
		this.numeroComprobante = numeroComprobante;
		this.numeroFactura = numeroFactura;
		this.nota = nota;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getNumeroComprobante() {
		return numeroComprobante;
	}

	public void setNumeroComprobante(Integer numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}
	

}
