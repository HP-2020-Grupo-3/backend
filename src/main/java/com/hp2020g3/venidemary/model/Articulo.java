package com.hp2020g3.venidemary.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "articulo")
public class Articulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	private String descripcion;
	private String imagen;
	private Integer stockActual;
	private Integer stockDeseado;
	private Date deletionDate;
	private Boolean isDeleted = false;
			
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rubroId")
	private Rubro rubro;
	
	public Articulo() {}
		
	public Articulo(Integer id, String nombre, String descripcion, String imagen, Integer stockActual,
			Integer stockDeseado, Date deletionDate, Boolean isDeleted, Rubro rubro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.stockActual = stockActual;
		this.stockDeseado = stockDeseado;
		this.deletionDate = deletionDate;
		this.isDeleted = isDeleted;
		this.rubro = rubro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Integer getStockActual() {
		return stockActual;
	}

	public void setStockActual(Integer stockActual) {
		this.stockActual = stockActual;
	}

	public Integer getStockDeseado() {
		return stockDeseado;
	}

	public void setStockDeseado(Integer stockDeseado) {
		this.stockDeseado = stockDeseado;
	}

	public Date getDeletionDate() {
		return deletionDate;
	}

	public void setDeletionDate(Date deletionDate) {
		this.deletionDate = deletionDate;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Rubro getRubro() {
		return rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}
	
	

}
