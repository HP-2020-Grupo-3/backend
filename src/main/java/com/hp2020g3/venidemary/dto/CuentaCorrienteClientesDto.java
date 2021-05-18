package com.hp2020g3.venidemary.dto;

import java.util.List;

public class CuentaCorrienteClientesDto {

    private List<CuentaCorrienteClienteDto> cuentaCorrienteClienteDtos;
    private Integer cantidadAprobacion;

    public CuentaCorrienteClientesDto() {
    }

    public CuentaCorrienteClientesDto(List<CuentaCorrienteClienteDto> cuentaCorrienteClienteDtos, Integer cantidadAprobacion) {
        this.cuentaCorrienteClienteDtos = cuentaCorrienteClienteDtos;
        this.cantidadAprobacion = cantidadAprobacion;
    }

    public List<CuentaCorrienteClienteDto> getCuentaCorrienteClienteDtos() {
        return cuentaCorrienteClienteDtos;
    }

    public void setCuentaCorrienteClienteDtos(List<CuentaCorrienteClienteDto> cuentaCorrienteClienteDtos) {
        this.cuentaCorrienteClienteDtos = cuentaCorrienteClienteDtos;
    }

    public Integer getCantidadAprobacion() {
        return cantidadAprobacion;
    }

    public void setCantidadAprobacion(Integer cantidadAprobacion) {
        this.cantidadAprobacion = cantidadAprobacion;
    }
}
