package com.hp2020g3.venidemary.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="ciudad")
public class Ciudad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private Integer codigoPostal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "provinciaId")
	@JsonIgnore
	private Provincia provincia;


	
	public Ciudad() {}
	
	public Ciudad (Integer id, Provincia provincia, String nombre, Integer codigoPostal) {
        this.id = id;
        this.provincia = provincia;
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
	}
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Provincia getProvincia() {
		return provincia;
	}
	
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
		

}
