package com.hp2020g3.venidemary.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity(name="venta")
public class Venta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private Date fecha;
	private Integer numeroComprobante;
	private boolean isEntregada;
	private String nota;
	
	@OneToMany(mappedBy="venta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LineaVenta> lineaVentas;
	
	@OneToMany(mappedBy="venta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LineaVentaCuentaCorriente> lineasVentaCuentaCorriente;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipoEntregaId")
	private TipoEntrega tipoEntrega;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "descuentoId")
	private Descuento descuento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medioPagoId")
	private MedioPago medioPago;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuarioEntityId")
	private Usuario usuario;
	
	public Venta () {}
	
	public Venta (Integer id, Date fecha, Integer numeroComprobante, boolean isEntregada, String nota, TipoEntrega tipoEntrega, Descuento descuento, MedioPago medioPago, Usuario usuario) {
		this.id = id;
		this.fecha = fecha;
		this.numeroComprobante = numeroComprobante;
		this.isEntregada = isEntregada;
		this.nota = nota;
		this.tipoEntrega = tipoEntrega;
		this.descuento = descuento;
		this.medioPago = medioPago;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getNumeroComprobante() {
		return numeroComprobante;
	}

	public void setNumeroComprobante(Integer numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}

	public boolean getIsEntregada() {
		return isEntregada;
	}

	public void setIsEntregada(boolean isEntregado) {
		this.isEntregada = isEntregado;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public TipoEntrega getTipoEntrega() {
		return tipoEntrega;
	}

	public void setTipoEntrega(TipoEntrega tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}

	public Descuento getDescuento() {
		return descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

	public MedioPago getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isEntregada() {
		return isEntregada;
	}

	public void setEntregada(boolean entregada) {
		isEntregada = entregada;
	}

	public List<LineaVenta> getLineaVentas() {
		return lineaVentas;
	}

	public void setLineaVentas(List<LineaVenta> lineaVentas) {
		this.lineaVentas = lineaVentas;
	}

	public List<LineaVentaCuentaCorriente> getLineasVentaCuentaCorriente() {
		return lineasVentaCuentaCorriente;
	}

	public void setLineasVentasCuentaCorriente(List<LineaVentaCuentaCorriente> lineasVentasCuentaCorriente) {
		this.lineasVentaCuentaCorriente = lineasVentasCuentaCorriente;
	}
	
	
}
