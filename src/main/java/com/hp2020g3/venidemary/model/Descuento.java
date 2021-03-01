package com.hp2020g3.venidemary.model;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Entity(name="descuento")
public class Descuento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private Float valor;
	private boolean isHabilitado;

    @Formula("CONCAT(valor * 100, '%')")
    private String displayText;
	
	public Descuento() {}
	
	public Descuento(Integer id, Float valor, boolean isHabilitado) {
		this.id = id;
		this.valor = valor;
		this.isHabilitado = isHabilitado;
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public boolean getIsHabilitado() {
		return isHabilitado;
	}
	public void setIsHabilitado(boolean isHabilitado) {
		this.isHabilitado = isHabilitado;
	}

	public boolean isHabilitado() {
		return isHabilitado;
	}

	public void setHabilitado(boolean habilitado) {
		isHabilitado = habilitado;
	}

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}
}
