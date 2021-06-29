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
	private Integer usuarioId;
	private List<LineaVentaDto> lineaVentaDtos;

	private Iterable<TipoEntrega> availableTipoEntrega;
	private Iterable<Descuento> availableDescuento;
	private Iterable<MedioPago> availableMedioPago;
	private Iterable<ArticuloDto> availableArticuloDto;

	private CuentaCorrienteClienteVentaDto selectedCuentaCorrienteClienteVentaDto;
	private Iterable<CuentaCorrienteClienteVentaDto> cuentaCorrienteClienteVentaDtos;
	private Boolean isPrecioCongelado;

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
		this.usuarioId = venta.getUsuario() != null ? venta.getUsuario().getId() : null;
		this.availableTipoEntrega = availableTipoEntrega;
		this.availableDescuento = availableDescuento;
		this.availableMedioPago = availableMedioPago;
		this.availableArticuloDto = availableArticuloDto;
		this.isPrecioCongelado = false;

		this.lineaVentaDtos = new ArrayList<LineaVentaDto>();
		if (venta.getLineasVenta() != null && !venta.getLineasVenta().isEmpty()) {
			for (LineaVenta lineaVenta: venta.getLineasVenta()) {
				this.lineaVentaDtos.add(new LineaVentaDto(lineaVenta));
			}
		} else if (venta.getLineasVentaCuentaCorriente() != null && !venta.getLineasVentaCuentaCorriente().isEmpty()) {
			// Cuenta Corriente
			for (LineaVentaCuentaCorriente lineaVenta: venta.getLineasVentaCuentaCorriente()) {
				this.lineaVentaDtos.add(new LineaVentaDto(lineaVenta));

				if (this.selectedCuentaCorrienteClienteVentaDto == null) {
					this.selectedCuentaCorrienteClienteVentaDto = new CuentaCorrienteClienteVentaDto(
							lineaVenta.getEstadoCuentaCorriente().getCuentaCorrienteCliente());
				}

				if (!this.isPrecioCongelado && lineaVenta.getPrecio() != null) {
					this.isPrecioCongelado = true;
				}
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

	public Iterable<CuentaCorrienteClienteVentaDto> getCuentaCorrienteClienteVentaDtos() {
		return cuentaCorrienteClienteVentaDtos;
	}

	public void setCuentaCorrienteClienteVentaDtos(Iterable<CuentaCorrienteClienteVentaDto> cuentaCorrienteClienteVentaDtos) {
		this.cuentaCorrienteClienteVentaDtos = cuentaCorrienteClienteVentaDtos;
	}

	public CuentaCorrienteClienteVentaDto getSelectedCuentaCorrienteClienteVentaDto() {
		return selectedCuentaCorrienteClienteVentaDto;
	}

	public void setSelectedCuentaCorrienteClienteVentaDto(CuentaCorrienteClienteVentaDto selectedCuentaCorrienteClienteVentaDto) {
		this.selectedCuentaCorrienteClienteVentaDto = selectedCuentaCorrienteClienteVentaDto;
	}

	public Boolean isPrecioCongelado() {
		return isPrecioCongelado;
	}

	public void setPrecioCongelado(Boolean precioCongelado) {
		isPrecioCongelado = precioCongelado;
	}
}
