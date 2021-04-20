package com.hp2020g3.venidemary.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="cuentaCorrienteCliente")
public class CuentaCorrienteCliente {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private Date fechaCreacion;
	private Boolean isAprobada = false;
	private Boolean isDeleted = false;
	private Date fechaDeletion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuarioEntityId")
	private Usuario usuario;
	
	@OneToMany(mappedBy="cuentaCorrienteCliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EstadoCuentaCorriente> estadosCuentaCorriente;
	
	public CuentaCorrienteCliente() {}
	
	public CuentaCorrienteCliente(Integer id, Date fechaCreacion, Boolean isAprobada, Boolean isDeleted, Date fechaDeletion, Usuario usuario, List<EstadoCuentaCorriente> estadosCuentaCorriente) {
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.isAprobada = isAprobada;
		this.isDeleted = isDeleted;
		this.fechaDeletion = fechaDeletion;
		this.usuario = usuario;
		this.estadosCuentaCorriente = estadosCuentaCorriente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Boolean getIsAprobada() {
		return isAprobada;
	}

	public void setIsAprobada(Boolean isAprobada) {
		this.isAprobada = isAprobada;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getFechaDeletion() {
		return fechaDeletion;
	}

	public void setFechaDeletion(Date fechaDeletion) {
		this.fechaDeletion = fechaDeletion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<EstadoCuentaCorriente> getEstadosCuentaCorriente() {
		return estadosCuentaCorriente;
	}

	public void setEstadosCuentaCorriente(List<EstadoCuentaCorriente> estadosCuentaCorriente) {
		this.estadosCuentaCorriente = estadosCuentaCorriente;
	}
	
}
