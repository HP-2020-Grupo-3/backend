package com.hp2020g3.venidemary.dto;

import com.hp2020g3.venidemary.model.Usuario;

public class UsuarioCCDto {
	
	private Integer id;
	private String username;
	private String nombre;
	private String apellido;
	private String email;
	
	public UsuarioCCDto () {}
	
	public UsuarioCCDto (Usuario usuario) {
		this.id = usuario.getId();
		this.username = usuario.getUsername();
		this.nombre = usuario.getNombre();
		this.apellido = usuario.getApellido();
		this.email = usuario.getEmail();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
