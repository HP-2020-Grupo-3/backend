package com.hp2020g3.venidemary.dto;

import com.hp2020g3.venidemary.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VentaDto {

    private Integer id;
	private Date fecha;
	private Integer numeroComprobante;
	private Boolean isEntregada;
	private String nota;
	private TipoEntrega currentTipoEntrega;
	private Descuento currentDescuento;
	private MedioPago currentMedioPago;
	private ComprobantePago comprobantePago;
	private Integer usuarioId;
	private List<LineaVentaDto> lineaVentaDtos;

	private Iterable<TipoEntrega> availableTipoEntrega;
	private Iterable<Descuento> availableDescuento;
	private Iterable<MedioPago> availableMedioPago;
	private Iterable<ArticuloDto> availableArticuloDto;

	public VentaDto(){};

	public VentaDto(Venta venta, Iterable<TipoEntrega> availableTipoEntrega, Iterable<Descuento> availableDescuento,
					Iterable<MedioPago> availableMedioPago, Iterable<ArticuloDto> availableArticuloDto) {
		this.id = venta.getId();
		this.fecha = venta.getFecha();
		this.numeroComprobante = venta.getNumeroComprobante();
		this.isEntregada = venta.getIsEntregada();
		this.nota = venta.getNota();
		this.currentTipoEntrega = venta.getTipoEntrega();
		this.currentDescuento = venta.getDescuento();
		this.currentMedioPago = venta.getMedioPago();
		this.comprobantePago = venta.getComprobantePago();
		this.usuarioId = venta.getUsuario() != null ? venta.getUsuario().getId() : null;
		this.availableTipoEntrega = availableTipoEntrega;
		this.availableDescuento = availableDescuento;
		this.availableMedioPago = availableMedioPago;
		this.availableArticuloDto = availableArticuloDto;

		this.lineaVentaDtos = new ArrayList<LineaVentaDto>();
		if (venta.getLineasVenta() != null) {
			for (LineaVenta lineaVenta: venta.getLineasVenta()) {
				this.lineaVentaDtos.add(new LineaVentaDto(lineaVenta));
			}
		}
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

	public Boolean isEntregada() {
		return isEntregada;
	}

	public void setEntregada(Boolean entregada) {
		isEntregada = entregada;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public TipoEntrega getCurrentTipoEntrega() {
		return currentTipoEntrega;
	}

	public void setCurrentTipoEntrega(TipoEntrega currentTipoEntrega) {
		this.currentTipoEntrega = currentTipoEntrega;
	}

	public Descuento getCurrentDescuento() {
		return currentDescuento;
	}

	public void setCurrentDescuento(Descuento currentDescuento) {
		this.currentDescuento = currentDescuento;
	}

	public MedioPago getCurrentMedioPago() {
		return currentMedioPago;
	}

	public void setCurrentMedioPago(MedioPago currentMedioPago) {
		this.currentMedioPago = currentMedioPago;
	}
	
	public ComprobantePago getComprobantePago() {
		return comprobantePago;
	}

	public void setComprobantePago(ComprobantePago comprobantePago) {
		this.comprobantePago = comprobantePago;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Iterable<TipoEntrega> getAvailableTipoEntrega() {
		return availableTipoEntrega;
	}

	public void setAvailableTipoEntrega(Iterable<TipoEntrega> availableTipoEntrega) {
		this.availableTipoEntrega = availableTipoEntrega;
	}

	public Iterable<Descuento> getAvailableDescuento() {
		return availableDescuento;
	}

	public void setAvailableDescuento(Iterable<Descuento> availableDescuento) {
		this.availableDescuento = availableDescuento;
	}

	public Iterable<MedioPago> getAvailableMedioPago() {
		return availableMedioPago;
	}

	public void setAvailableMedioPago(Iterable<MedioPago> availableMedioPago) {
		this.availableMedioPago = availableMedioPago;
	}

	public List<LineaVentaDto> getLineaVentaDtos() {
		return lineaVentaDtos;
	}

	public void setLineaVentaDtos(List<LineaVentaDto> lineaVentaDtos) {
		this.lineaVentaDtos = lineaVentaDtos;
	}

	public Iterable<ArticuloDto> getAvailableArticuloDto() {
		return availableArticuloDto;
	}

	public void setAvailableArticuloDto(Iterable<ArticuloDto> availableArticuloDto) {
		this.availableArticuloDto = availableArticuloDto;
	}
}
