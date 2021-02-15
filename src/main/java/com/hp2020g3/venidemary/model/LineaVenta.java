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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comprobantePagoId")
	private ComprobantePago comprobantePago;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ventaId")
	private Venta venta;
	
	public LineaVenta() {}
	
	public LineaVenta (Integer id, Integer cantidad, boolean isPago, Articulo articulo, Precio precio, ComprobantePago comprobantePago, Venta venta) {
		
		this.id = id;
		this.cantidad = cantidad;
		this.isPago = isPago;
		this.articulo = articulo;
		this.precio = precio;
		this.comprobantePago = comprobantePago;
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

	public ComprobantePago getComprobantePago() {
		return comprobantePago;
	}

	public void setComprobantePago(ComprobantePago comprobantePago) {
		this.comprobantePago = comprobantePago;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
}
