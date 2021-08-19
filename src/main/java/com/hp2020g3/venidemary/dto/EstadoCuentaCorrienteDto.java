package com.hp2020g3.venidemary.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hp2020g3.venidemary.model.*;

public class EstadoCuentaCorrienteDto {
	
	private Integer id;
	private Integer cantidad;
	private ArticuloDto articulo;
	private Precio precio;
	private List<LineaVentaDto> lineasVentaPendienteDePago;
	private List<PagoCuentaCorriente> pagosCuentaCorriente;
	private Integer cantidadAPagar;

	public EstadoCuentaCorrienteDto() {}
	public EstadoCuentaCorrienteDto(EstadoCuentaCorriente estado) {
		this.id = estado.getId();
		this.cantidad = estado.getCantidad();
		this.articulo = new ArticuloDto(estado.getArticulo());
		this.precio = estado.getArticulo().getPrecio();
		this.cantidadAPagar = 0;

		this.lineasVentaPendienteDePago = estado.getLineasVentaCuentaCorrientePendienteDePago()
				.stream().map(lineaVenta -> new LineaVentaDto(lineaVenta))
				.collect(Collectors.toList());
	}

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

	public ArticuloDto getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloDto articulo) {
		this.articulo = articulo;
	}

	public Precio getPrecio() {
		return precio;
	}

	public void setPrecio(Precio precio) {
		this.precio = precio;
	}

	public List<LineaVentaDto> getLineasVentaPendienteDePago() {
		return lineasVentaPendienteDePago;
	}

	public void setLineasVentaPendienteDePago(List<LineaVentaDto> lineasVentaPendienteDePago) {
		this.lineasVentaPendienteDePago = lineasVentaPendienteDePago;
	}

	public List<PagoCuentaCorriente> getPagosCuentaCorriente() {
		return pagosCuentaCorriente;
	}

	public void setPagosCuentaCorriente(List<PagoCuentaCorriente> pagosCuentaCorriente) {
		this.pagosCuentaCorriente = pagosCuentaCorriente;
	}

	public Integer getCantidadAPagar() {
		return cantidadAPagar;
	}

	public void setCantidadAPagar(Integer cantidadAPagar) {
		this.cantidadAPagar = cantidadAPagar;
	}
}
