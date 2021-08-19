package com.hp2020g3.venidemary.dto;

import java.util.Date;

import com.hp2020g3.venidemary.model.ComprobantePago;
import com.hp2020g3.venidemary.model.Venta;

public class ComprobantePagoDto {
	
	Integer id;
	Date fecha;
	Integer numeroComprobante;
	String numeroFactura;
	String nota;
	Integer idVenta;
	Double totalVenta;
	
	public ComprobantePagoDto() {}
	
	public ComprobantePagoDto(Integer id, Date fecha, Integer numeroComprobante, String numeroFactura, String nota, Integer idVenta) {
		this.id = id;
		this.fecha = fecha;
		this.numeroComprobante = numeroComprobante;
		this.numeroFactura = numeroFactura;
		this.nota = nota;
		this.idVenta = idVenta;
	}
	
	public ComprobantePagoDto(ComprobantePago comprobantePago, Venta venta) {
		this.id = comprobantePago.getId();
		this.fecha = comprobantePago.getFecha();
		this.numeroComprobante = comprobantePago.getNumeroComprobante();
		this.numeroFactura = comprobantePago.getNumeroFactura();
		this.nota = comprobantePago.getNota();
		this.idVenta = venta.getId();
		this.totalVenta = venta.getTotal();
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

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public Double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(Double totalVenta) {
		this.totalVenta = totalVenta;
	}
	
	
}
