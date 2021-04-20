package com.hp2020g3.venidemary.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="lineaVentaCuentaCorriente")
public class LineaVentaCuentaCorriente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private Integer cantidad;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estadoCuentaCorrienteId")
	private EstadoCuentaCorriente estadoCuentaCorriente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ventaId")
	private Venta venta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "precioId")
	private Precio precio;
	
	public LineaVentaCuentaCorriente() {}
	
	public LineaVentaCuentaCorriente(Integer id, Integer cantidad, EstadoCuentaCorriente estadoCuentaCorriente, Venta venta, Precio precio) {
		this.id = id;
		this.cantidad = cantidad;
		this.estadoCuentaCorriente = estadoCuentaCorriente;
		this.venta = venta;
		this.precio = precio;
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

	public EstadoCuentaCorriente getEstadoCuentaCorriente() {
		return estadoCuentaCorriente;
	}

	public void setEstadoCuentaCorriente(EstadoCuentaCorriente estadoCuentaCorriente) {
		this.estadoCuentaCorriente = estadoCuentaCorriente;
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
