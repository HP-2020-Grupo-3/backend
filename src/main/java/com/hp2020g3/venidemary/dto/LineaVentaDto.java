package com.hp2020g3.venidemary.dto;

import com.hp2020g3.venidemary.model.LineaVenta;
import com.hp2020g3.venidemary.model.Precio;

public class LineaVentaDto {

    private Integer id;
	private Integer cantidad;
    private boolean isPago;
    private Double precio;
    private String articuloNombre;
    private Integer articuloId;

    public LineaVentaDto() {}

    public LineaVentaDto(LineaVenta lineaVenta) {
        this.id = lineaVenta.getId();
        this.cantidad = lineaVenta.getCantidad();
        this.isPago = lineaVenta.getIsPago();
        this.precio = lineaVenta.getPrecio().getValor();
        if (lineaVenta.getArticulo() != null) {
            this.articuloNombre = lineaVenta.getArticulo().getNombre();
            this.articuloId = lineaVenta.getArticulo().getId();
        } else {
            this.articuloNombre = null;
            this.articuloId = null;
        }
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

    public boolean isPago() {
        return isPago;
    }

    public void setPago(boolean pago) {
        isPago = pago;
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
}
