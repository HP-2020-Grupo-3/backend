package com.hp2020g3.venidemary.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="estadoCuentaCorriente")
public class EstadoCuentaCorriente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private Integer cantidad;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cuentaCorrienteClienteId")
	private CuentaCorrienteCliente cuentaCorrienteCliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "articuloId")
	private Articulo articulo;
	
	@OneToMany(mappedBy="estadoCuentaCorriente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PagoCuentaCorriente> pagosCuentaCorriente;
	
	@OneToMany(mappedBy="estadoCuentaCorriente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LineaVentaCuentaCorriente> lineasVentaCuentaCorriente;
	
	public EstadoCuentaCorriente() {}
	
	public EstadoCuentaCorriente(Integer id, Integer cantidad, CuentaCorrienteCliente cuentaCorrienteCliente, Articulo articulo, List<LineaVentaCuentaCorriente> lineasVentaCuentaCorriente, List<PagoCuentaCorriente> pagosCuentaCorriente) {
		this.id = id;
		this.cantidad = cantidad;
		this.cuentaCorrienteCliente = cuentaCorrienteCliente;
		this.articulo = articulo;
		this.lineasVentaCuentaCorriente = lineasVentaCuentaCorriente;
		this.pagosCuentaCorriente = pagosCuentaCorriente;
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

	public CuentaCorrienteCliente getCuentaCorrienteCliente() {
		return cuentaCorrienteCliente;
	}

	public void setCuentaCorrienteCliente(CuentaCorrienteCliente cuentaCorrienteCliente) {
		this.cuentaCorrienteCliente = cuentaCorrienteCliente;
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
