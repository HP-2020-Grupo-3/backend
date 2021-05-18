package com.hp2020g3.venidemary.dto;

import java.util.Date;

import com.hp2020g3.venidemary.model.CuentaCorrienteCliente;


public class CuentaCorrienteClienteDto {
	
	private Integer id;
	private String username;
	private String nombre;
	private String apellido;
	private Date fechaCreacion;
	private boolean isAprobada;
	private boolean isDeleted;

	public CuentaCorrienteClienteDto() {}
	
	public CuentaCorrienteClienteDto(CuentaCorrienteCliente cuentaCorrienteCliente) {
		this.id = cuentaCorrienteCliente.getId();
		this.username = cuentaCorrienteCliente.getUsuario().getUsername();
		this.nombre = cuentaCorrienteCliente.getUsuario().getNombre();
		this.apellido = cuentaCorrienteCliente.getUsuario().getApellido();
		this.fechaCreacion = cuentaCorrienteCliente.getFechaCreacion();
		this.isAprobada = cuentaCorrienteCliente.getIsAprobada();
		this.isDeleted = cuentaCorrienteCliente.getIsDeleted();
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public boolean getIsAprobada() {
		return isAprobada;
	}

	public void setIsAprobada(boolean isAprobada) {
		this.isAprobada = isAprobada;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
