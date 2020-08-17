package com.hp2020g3.venidemary.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "entityType")
public class EntityType {

    @Id
    private Integer id;

    private String nombre;

    public EntityType() {}

    public EntityType(Integer id, String nombre) {
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
