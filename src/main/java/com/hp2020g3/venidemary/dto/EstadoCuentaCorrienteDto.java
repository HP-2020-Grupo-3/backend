package com.hp2020g3.venidemary.dto;

import java.util.List;

import com.hp2020g3.venidemary.model.Articulo;
import com.hp2020g3.venidemary.model.LineaVentaCuentaCorriente;
import com.hp2020g3.venidemary.model.PagoCuentaCorriente;

public class EstadoCuentaCorrienteDto {
	
	private Integer id;
	private Integer cantidad;
	private Articulo articulo;
	private List<PagoCuentaCorriente> pagosCuentaCorriente;
	private List<LineaVentaCuentaCorriente> lineasVentaCuentaCorriente;
	
	public EstadoCuentaCorrienteDto() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public List<PagoCuentaCorriente> getPagosCuentaCorriente() {
		return pagosCuentaCorriente;
	}

	public void setPagosCuentaCorriente(List<PagoCuentaCorriente> pagosCuentaCorriente) {
		this.pagosCuentaCorriente = pagosCuentaCorriente;
	}

	public List<LineaVentaCuentaCorriente> getLineasVentaCuentaCorriente() {
		return lineasVentaCuentaCorriente;
	}

	public void setLineasVentaCuentaCorriente(List<LineaVentaCuentaCorriente> lineasVentaCuentaCorriente) {
		this.lineasVentaCuentaCorriente = lineasVentaCuentaCorriente;
	}
	
}
