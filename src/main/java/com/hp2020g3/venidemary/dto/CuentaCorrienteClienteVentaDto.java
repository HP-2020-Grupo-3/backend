package com.hp2020g3.venidemary.dto;

import com.hp2020g3.venidemary.model.CuentaCorrienteCliente;

import java.util.Date;


public class CuentaCorrienteClienteVentaDto {

	private Integer id;
	private String username;
	private String nombre;
	private String apellido;
	private Double total;

	public CuentaCorrienteClienteVentaDto() {}

	public CuentaCorrienteClienteVentaDto(CuentaCorrienteCliente cuentaCorrienteCliente) {
		this.id = cuentaCorrienteCliente.getId();
		this.username = cuentaCorrienteCliente.getUsuario().getUsername();
		this.nombre = cuentaCorrienteCliente.getUsuario().getNombre();
		this.apellido = cuentaCorrienteCliente.getUsuario().getApellido();
		this.total = cuentaCorrienteCliente.getTotal();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
}
