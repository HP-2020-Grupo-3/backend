package com.hp2020g3.venidemary.dto;

import com.hp2020g3.venidemary.model.Rubro;

public class RubroDto {
	
	private Integer id;
    private String nombre;

    public RubroDto(Rubro rubro) {
        this.id = rubro.getId();
        this.nombre = rubro.getNombre();
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
