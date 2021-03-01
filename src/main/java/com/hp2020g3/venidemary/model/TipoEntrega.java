package com.hp2020g3.venidemary.model;

import javax.persistence.*;

@Entity(name="tipoEntrega")
public class TipoEntrega {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    public TipoEntrega() {}

    public TipoEntrega(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
    

}
