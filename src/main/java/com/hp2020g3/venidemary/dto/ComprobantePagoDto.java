package com.hp2020g3.venidemary.dto;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.hp2020g3.venidemary.model.*;

public class ComprobantePagoDto {
	
	Integer id;
	Date fecha;
	Integer numeroComprobante;
	String numeroFactura;
	String nota;
	Integer idVenta;
	Integer idCuentaCorriente;
	Double totalVenta;
	List<LineaVentaDto> lineaVentaDtos;
	Descuento descuento;
	
	public ComprobantePagoDto() {}
	
	public ComprobantePagoDto(Integer id, Date fecha, Integer numeroComprobante, String numeroFactura, String nota, Integer idVenta) {
		this.id = id;
		this.fecha = fecha;
		this.numeroComprobante = numeroComprobante;
		this.numeroFactura = numeroFactura;
		this.nota = nota;
		this.idVenta = idVenta;
	}
	
	public ComprobantePagoDto(ComprobantePago comprobantePago) {
		this.id = comprobantePago.getId();
		this.fecha = comprobantePago.getFecha();
		this.numeroComprobante = comprobantePago.getNumeroComprobante();
		this.numeroFactura = comprobantePago.getNumeroFactura();
		this.nota = comprobantePago.getNota();
	}

	public ComprobantePagoDto(ComprobantePago comprobantePago, Venta venta) {
		this(comprobantePago);
		this.idVenta = venta.getId();
		this.totalVenta = venta.getTotal();
		this.descuento = venta.getDescuento();
		this.lineaVentaDtos = venta.getLineasVenta().stream()
				.map(lineaVenta -> new LineaVentaDto(lineaVenta))
				.collect(Collectors.toList());
	}

	public ComprobantePagoDto(ComprobantePago comprobantePago, List<LineaComprobantePagoInterface> lineas) {
		this(comprobantePago);

		this.lineaVentaDtos = lineas.stream()
			.map(linea -> new LineaVentaDto(linea))
			.collect(Collectors.toList());

		this.totalVenta = this.lineaVentaDtos.stream()
				.map(lineaVentaDto -> lineaVentaDto.getPrecio() * lineaVentaDto.getCantidad())
				.reduce(0d, (lst, rst) -> lst + rst);
	}

//	public ComprobantePagoDto(ComprobantePago cp, List<LineaVentaCuentaCorriente> lineasVentaCC) {
//
//	}

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

	public List<LineaVentaDto> getLineaVentaDtos() {
		return lineaVentaDtos;
	}

	public void setLineaVentaDtos(List<LineaVentaDto> lineaVentaDtos) {
		this.lineaVentaDtos = lineaVentaDtos;
	}

	public Descuento getDescuento() {
		return descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}
}
