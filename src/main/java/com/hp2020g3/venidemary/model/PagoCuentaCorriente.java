package com.hp2020g3.venidemary.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="pagoCuentaCorriente")
public class PagoCuentaCorriente implements LineaComprobantePagoInterface {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private Integer cantidad;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estadoCuentaCorrienteId")
	private EstadoCuentaCorriente estadoCuentaCorriente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comprobantePagoId")
	private ComprobantePago comprobantePago;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "precioId")
	private Precio precio;
	
	public PagoCuentaCorriente() {}
	
	public PagoCuentaCorriente(Integer id, Integer cantidad, EstadoCuentaCorriente estadoCuentaCorriente, ComprobantePago comprobantePago, Precio precio) {
		this.id = id;
		this.cantidad = cantidad;
		this.estadoCuentaCorriente = estadoCuentaCorriente;
		this.comprobantePago = comprobantePago;
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

	@Override
	public Double getPrecioValor() {
		return this.getPrecio().getValor();
	}

	@Override
	public String getArticuloNombre() {
		return this.getEstadoCuentaCorriente().getArticulo().getNombre();
	}

	@Override
	public Integer getArticuloId() {
		return this.getEstadoCuentaCorriente().getArticulo().getId();
	}
}
