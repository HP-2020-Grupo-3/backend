package com.hp2020g3.venidemary.model;

import javax.persistence.*;


@Entity(name="ciudad")
public class Ciudad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer provinciaId;
	private String nombre;
	private Integer codigoPostal;
	
	@ManyToOne
	@JoinColumn(name="provinciaId", insertable= false, updatable=false)
	private Ciudad ciudad;


	
	public Ciudad() {}
	
	public Ciudad (Integer id, Integer provinciaId, String nombre, Integer codigoPostal) {
        this.id = id;
        this.provinciaId = provinciaId;
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
	}
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getProvinciaId() {
		return provinciaId;
	}
	
	public void setProvinciaId(Integer provinciaId) {
		this.provinciaId = provinciaId;
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
