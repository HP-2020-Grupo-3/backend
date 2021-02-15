package com.hp2020g3.venidemary.model;

import javax.persistence.*;

@Entity(name="descuento")
public class Descuento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private Float valor;
	private boolean isHabilitado;
	
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
	
}
