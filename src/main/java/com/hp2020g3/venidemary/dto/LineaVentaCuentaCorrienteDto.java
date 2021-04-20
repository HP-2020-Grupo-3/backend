package com.hp2020g3.venidemary.dto;

import com.hp2020g3.venidemary.model.Precio;
import com.hp2020g3.venidemary.model.Venta;

public class LineaVentaCuentaCorrienteDto {
	
	private Integer id;
	private Integer cantidad;
	private Venta venta;
	private Precio precio;
	
	public LineaVentaCuentaCorrienteDto() {}

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

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Precio getPrecio() {
		return precio;
	}

	public void setPrecio(Precio precio) {
		this.precio = precio;
	}
	
}
