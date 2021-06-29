package com.hp2020g3.venidemary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name="lineaVenta")
public class LineaVenta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private Integer cantidad;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "articuloId")
	private Articulo articulo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "precioId")
	private Precio precio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ventaId")
	@JsonIgnore
	private Venta venta;
	
	public LineaVenta() {}
	
	public LineaVenta (Integer id, Integer cantidad, Articulo articulo, Precio precio, Venta venta) {
		
		this.id = id;
		this.cantidad = cantidad;
		this.articulo = articulo;
		this.precio = precio;
		this.venta = venta;
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

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Precio getPrecio() {
		return precio;
	}

	public void setPrecio(Precio precio) {
		this.precio = precio;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
}
