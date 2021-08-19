package com.hp2020g3.venidemary.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.hp2020g3.venidemary.model.CuentaCorrienteCliente;
import com.hp2020g3.venidemary.model.Usuario;


public class CuentaCorrienteClienteDto {
	
	private Integer id;
	private String username;
	private String nombre;
	private String apellido;
	private Date fechaCreacion;
	private boolean isAprobada;
	private boolean isDeleted;
	private Integer usuarioId;
	private List<UsuarioCCDto> usuarioCCDtos;
	private List<EstadoCuentaCorrienteDto> estadoCuentaCorrienteDtos;
	private List<LineaVentaDto> lineasVentaPendienteDePago;


	public CuentaCorrienteClienteDto() {}
	
	public CuentaCorrienteClienteDto(CuentaCorrienteCliente cuentaCorrienteCliente) {
		this.id = cuentaCorrienteCliente.getId();
		this.username = cuentaCorrienteCliente.getUsuario().getUsername();
		this.nombre = cuentaCorrienteCliente.getUsuario().getNombre();
		this.apellido = cuentaCorrienteCliente.getUsuario().getApellido();
		this.fechaCreacion = cuentaCorrienteCliente.getFechaCreacion();
		this.isAprobada = cuentaCorrienteCliente.getIsAprobada();
		this.isDeleted = cuentaCorrienteCliente.getIsDeleted();

		this.estadoCuentaCorrienteDtos = cuentaCorrienteCliente
				.getEstadosCuentaCorriente()
				.stream().map(estadoCuentaCorriente -> new EstadoCuentaCorrienteDto(estadoCuentaCorriente))
				.collect(Collectors.toList());

		this.lineasVentaPendienteDePago = this.estadoCuentaCorrienteDtos.stream()
				.flatMap(estadoCuentaCorrienteDto -> estadoCuentaCorrienteDto.getLineasVentaPendienteDePago().stream())
				.collect(Collectors.toList());
	}
	
	public CuentaCorrienteClienteDto (Iterable<Usuario> usuarios) {
		this.fechaCreacion = new Date();
		this.isAprobada = false;
		this.isDeleted = false;		
		this.usuarioId = null;
		System.out.println();
		System.out.println(usuarios);
		System.out.println();
		usuarioCCDtos = StreamSupport.stream(usuarios.spliterator(), false)
                .map(usuario -> new UsuarioCCDto(usuario))
                .collect(Collectors.toList());
		
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
	
	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public List<UsuarioCCDto> getUsuarioCCDtos() {
		return usuarioCCDtos;
	}

	public void setUsuarioCCDtos(ArrayList<UsuarioCCDto> usuarioCCDtos) {
		this.usuarioCCDtos = usuarioCCDtos;
	}

	public List<EstadoCuentaCorrienteDto> getEstadoCuentaCorrienteDtos() {
		return estadoCuentaCorrienteDtos;
	}

	public void setEstadoCuentaCorrienteDtos(List<EstadoCuentaCorrienteDto> estadoCuentaCorrienteDtos) {
		this.estadoCuentaCorrienteDtos = estadoCuentaCorrienteDtos;
	}

	public List<LineaVentaDto> getLineasVentaPendienteDePago() {
		return lineasVentaPendienteDePago;
	}

	public void setLineasVentaPendienteDePago(List<LineaVentaDto> lineasVentaPendienteDePago) {
		this.lineasVentaPendienteDePago = lineasVentaPendienteDePago;
	}
}
