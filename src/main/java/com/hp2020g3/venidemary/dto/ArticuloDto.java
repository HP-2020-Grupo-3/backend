package com.hp2020g3.venidemary.dto;


import java.util.Optional;

import com.hp2020g3.venidemary.model.Articulo;
import com.hp2020g3.venidemary.model.Precio;
import com.hp2020g3.venidemary.model.Rubro;
import com.hp2020g3.venidemary.utils.Constants;

public class ArticuloDto {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private Integer stockActual;
	private Integer stockDeseado;
	private Double precio;
	private Rubro currentRubro;
	private Iterable<Rubro> availableRubros;
	
	public ArticuloDto () {}

	public ArticuloDto (Articulo articulo) {
		this.id = articulo.getId();
		this.nombre = articulo.getNombre();
		this.descripcion = articulo.getDescripcion();
		this.imagen = articulo.getImagen();
		this.stockActual = articulo.getStockActual();
		this.stockDeseado = articulo.getStockDeseado();
		this.currentRubro = articulo.getRubro();
		if (articulo.getPrecio() != null) {
			this.precio = articulo.getPrecio().getValor();
		} else {
			this.precio = 0.0;
		}
	}

	public ArticuloDto (Articulo articulo, Iterable<Rubro> rubroList) {
		this(articulo);
		this.availableRubros = rubroList;
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
	
	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
