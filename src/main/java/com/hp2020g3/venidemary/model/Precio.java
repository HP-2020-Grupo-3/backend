package com.hp2020g3.venidemary.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="precio")
public class Precio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private Double valor;
	private Date fecha;
	
	@OneToMany(mappedBy="precio", fetch = FetchType.LAZY)
	@JsonIgnore
    private List<LineaVenta> lineaVentaList;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "articuloId")
	@JsonIgnore
	private Articulo articulo;
	
	public Precio() {}
	
	public Precio(Integer id, Double valor, Date fecha, Articulo articulo) {
		this.id = id;
		this.valor = valor;
		this.fecha = fecha;
		this.articulo = articulo;
	}

	public Precio(Double valor, Articulo articulo) {
		this.valor = valor;
		this.fecha = new Date();
		this.articulo = articulo;
	}

	public Precio(double v) {
		this.valor = v;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<LineaVenta> getLineaVentaList() {
		return lineaVentaList;
	}

	public void setLineaVentaList(List<LineaVenta> lineaVentaList) {
		this.lineaVentaList = lineaVentaList;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
}
