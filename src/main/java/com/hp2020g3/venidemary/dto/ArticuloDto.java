package com.hp2020g3.venidemary.dto;


import java.util.Optional;

import com.hp2020g3.venidemary.model.Articulo;
import com.hp2020g3.venidemary.model.Rubro;

public class ArticuloDto {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private Integer stockActual;
	private Integer stockDeseado;
	private Rubro currentRubro;
	private Iterable<Rubro> availableRubros;
	
	public ArticuloDto () {}

	public ArticuloDto (Articulo articulo, Iterable<Rubro> rubroList) {

		this.id = articulo.getId();
		this.nombre = articulo.getNombre();
		this.descripcion = articulo.getDescripcion();
		this.imagen = articulo.getImagen();
		this.stockActual = articulo.getStockActual();
		this.stockDeseado = articulo.getStockDeseado();
		this.currentRubro = articulo.getRubro();
		this.availableRubros = rubroList;
	}

	public ArticuloDto (Optional<Articulo> articulo, Iterable<Rubro> rubroList) {

		if(articulo.get() != null) {
			this.id = articulo.get().getId();
			this.nombre = articulo.get().getNombre();
			this.descripcion = articulo.get().getDescripcion();
			this.imagen = articulo.get().getImagen();
			this.stockActual = articulo.get().getStockActual();
			this.stockDeseado = articulo.get().getStockDeseado();
			this.currentRubro = articulo.get().getRubro();
			this.availableRubros = rubroList;
		} else {
			//Tirar algun error
		}
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

	public Rubro getCurrentRubro() {
		return currentRubro;
	}

	public void setCurrentRubro(Rubro currentRubro) {
		this.currentRubro = currentRubro;
	}


	public Iterable<Rubro> getAvailableRubros() {
		return availableRubros;
	}

	public void setAvailableRubros(Iterable<Rubro> availableRubros) {
		this.availableRubros = availableRubros;
	}
	
	
}
