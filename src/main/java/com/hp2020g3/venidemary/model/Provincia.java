package com.hp2020g3.venidemary.model;

import java.util.List;
import javax.persistence.*;


@Entity(name="provincia")

public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    
    @OneToMany(mappedBy="provinciaId")
    private List<Ciudad> ciudades;

    public Provincia() {}

    public Provincia(Integer id, String nombre) {
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
    
    public List<Ciudad> getCiudades(){
    	return ciudades;
    }
    
    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
}
