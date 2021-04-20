package com.hp2020g3.venidemary.dto;

import java.util.List;
import com.hp2020g3.venidemary.model.EstadoCuentaCorriente;

public class CuentaCorrienteClienteDto {
	
	private List<EstadoCuentaCorriente> estadosCuentaCorriente;
	
	public CuentaCorrienteClienteDto() {}

	public List<EstadoCuentaCorriente> getEstadosCuentaCorriente() {
		return estadosCuentaCorriente;
	}

	public void setEstadosCuentaCorriente(List<EstadoCuentaCorriente> estadosCuentaCorriente) {
		this.estadosCuentaCorriente = estadosCuentaCorriente;
	}
	
}
