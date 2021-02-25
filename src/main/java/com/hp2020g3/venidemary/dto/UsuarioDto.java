package com.hp2020g3.venidemary.dto;

import java.util.Optional;

import com.hp2020g3.venidemary.model.Role;
import com.hp2020g3.venidemary.model.Usuario;

public class UsuarioDto {
	
	private Integer id;
	private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String email;
    private Role currentRole;
    private Iterable<Role> availableRoles;
    
    public UsuarioDto() {}
    
    public UsuarioDto(Usuario usuario, Iterable<Role> roleList) {
    	this.id = usuario.getId();
    	this.username = usuario.getUsername();
    	this.password = usuario.getPassword();
    	this.nombre = usuario.getNombre();
    	this.apellido = usuario.getApellido();
    	this.email = usuario.getEmail();
    	this.currentRole = usuario.getRole();
    	this.availableRoles = roleList;
    }
    
    public UsuarioDto( Optional<Usuario> usuario, Iterable<Role> roleList) {
    	
    	if(usuario.get() != null) {
	    	this.id = usuario.get().getId();
	    	this.username = usuario.get().getUsername();
	    	this.password = usuario.get().getPassword();
	    	this.nombre = usuario.get().getNombre();
	    	this.apellido = usuario.get().getApellido();
	    	this.email = usuario.get().getEmail();
	    	this.currentRole = usuario.get().getRole();
	    	this.availableRoles = roleList;
    	}
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Role getCurrentRole() {
		return currentRole;
	}

	public void setCurrentRole(Role currentRole) {
		this.currentRole = currentRole;
	}

	public Iterable<Role> getAvailableRoles() {
		return availableRoles;
	}

	public void setAvailableRoles(Iterable<Role> availableRoles) {
		this.availableRoles = availableRoles;
	}
    
    
}
