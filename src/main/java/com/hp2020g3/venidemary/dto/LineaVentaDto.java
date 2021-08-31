package com.hp2020g3.venidemary.dto;

import com.hp2020g3.venidemary.model.*;

public class LineaVentaDto {

    private Integer id;
	private Integer cantidad;
    private Double precio;
    private String articuloNombre;
    private Integer articuloId;
    private Boolean isPago;

    private Boolean aSerPagado;

    public LineaVentaDto() {}

    public LineaVentaDto(LineaVenta lineaVenta) {
        this.id = lineaVenta.getId();
        this.cantidad = lineaVenta.getCantidad();
        this.precio = lineaVenta.getPrecio().getValor();
        if (lineaVenta.getArticulo() != null) {
            this.articuloNombre = lineaVenta.getArticulo().getNombre();
            this.articuloId = lineaVenta.getArticulo().getId();
        } else {
            this.articuloNombre = null;
            this.articuloId = null;
        }
    }

    public  LineaVentaDto(LineaVentaCuentaCorriente lineaVenta) {
        this.id = lineaVenta.getId();
        this.cantidad = lineaVenta.getCantidad();
        this.aSerPagado = false;

        if (lineaVenta.getPrecio() != null) {
            this.precio = lineaVenta.getPrecio().getValor();
        } else {
            this.precio = lineaVenta.getEstadoCuentaCorriente().getArticulo().getPrecio().getValor();
        }

        if (lineaVenta.getEstadoCuentaCorriente().getArticulo() != null) {
            this.articuloNombre = lineaVenta.getEstadoCuentaCorriente().getArticulo().getNombre();
            this.articuloId = lineaVenta.getEstadoCuentaCorriente().getArticulo().getId();
        } else {
            this.articuloNombre = null;
            this.articuloId = null;
        }
    }

    public LineaVentaDto(LineaComprobantePagoInterface linea) {
//        this.id = linea.getId();
        this.cantidad = linea.getCantidad();
        this.precio = linea.getPrecioValor();
        this.articuloNombre = linea.getArticuloNombre();
        this.articuloId = linea.getArticuloId();
        this.isPago = true;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getArticuloNombre() {
        return articuloNombre;
    }

    public void setArticuloNombre(String articuloNombre) {
        this.articuloNombre = articuloNombre;
    }

    public Integer getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(Integer articuloId) {
        this.articuloId = articuloId;
    }

    public Boolean getIsPago() {
        return isPago;
    }

    public void setIsPago(Boolean pago) {
        isPago = pago;
    }

    public Boolean getaSerPagado() {
        return aSerPagado;
    }

    public void setaSerPagado(Boolean aSerPagado) {
        this.aSerPagado = aSerPagado;
    }

}
