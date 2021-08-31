package com.hp2020g3.venidemary.dto;

import com.hp2020g3.venidemary.model.MedioPago;
import com.hp2020g3.venidemary.model.Venta;

import java.util.Date;

public class VentaListItemDto {
    private Integer id;
	private Date fecha;
	private Integer numeroComprobante;
	private MedioPago medioPago;
	private ComprobantePagoDto comprobantePagoDto;
	private Double total;

    public VentaListItemDto() {}

    public VentaListItemDto(Venta venta) {
        this.id = venta.getId();
        this.fecha = venta.getFecha();
        this.numeroComprobante = venta.getNumeroComprobante();
        this.medioPago = venta.getMedioPago();
        this.total = venta.getTotal();
    }
    public VentaListItemDto(Venta venta, ComprobantePagoDto comprobantePagoDto) {
        this(venta);
        this.comprobantePagoDto = comprobantePagoDto;
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

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    public ComprobantePagoDto getComprobantePagoDto() {
        return comprobantePagoDto;
    }

    public void setComprobantePagoDto(ComprobantePagoDto comprobantePagoDto) {
        this.comprobantePagoDto = comprobantePagoDto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
