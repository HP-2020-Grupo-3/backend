package com.hp2020g3.venidemary.dto;

import com.hp2020g3.venidemary.model.ComprobantePago;
import com.hp2020g3.venidemary.model.Precio;

public class PagoCuentaCorrienteDto {
	
	private Integer id;
	private Integer cantidad;
	private ComprobantePago comprobantePago;
	private Precio precio;
	
	public PagoCuentaCorrienteDto (){}

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

	public ComprobantePago getComprobantePago() {
		return comprobantePago;
	}

	public void setComprobantePago(ComprobantePago comprobantePago) {
		this.comprobantePago = comprobantePago;
	}

	public Precio getPrecio() {
		return precio;
	}

	public void setPrecio(Precio precio) {
		this.precio = precio;
	}
	
}
