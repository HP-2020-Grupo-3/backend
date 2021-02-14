package com.hp2020g3.venidemary.model;

import javax.persistence.*;

@Entity(name="lineaventa")
public class LineaVenta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private Integer cantidad;
	private boolean isPago;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "articuloId")
	private Articulo articulo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "precioId")
	private Precio precio;
	
	
	//TODO Clases ComprobantePago y Venta
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comprobantePagoId")
	private ComprobantePago comprobantePago;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ventaId")
	private Venta venta;
	*/
	
	public LineaVenta() {}
	
	public LineaVenta (Integer id, Integer cantidad, boolean isPago, Articulo articulo, Precio precio ) {
		
		this.id = id;
		this.cantidad = cantidad;
		this.isPago = isPago;
		this.articulo = articulo;
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

	public boolean getIsPago() {
		return isPago;
	}

	public void setIsPago(boolean isPago) {
		this.isPago = isPago;
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
	
}
