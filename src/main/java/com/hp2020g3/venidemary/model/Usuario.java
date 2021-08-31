package com.hp2020g3.venidemary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.userdetails.User;

import com.hp2020g3.venidemary.dto.UsuarioDto;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "usuario")
@PrimaryKeyJoinColumn(name = "entityId")
public class Usuario extends BaseEntity {
	
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String email;
    
    private EntityType entityType = new EntityType(1, "Usuario");
    
    //private Boolean isDeleted = false;
    

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;
    
    @OneToMany(mappedBy ="usuario", fetch = FetchType.LAZY)
    private List<Direccion> direcciones;

    @JsonIgnore
    @OneToOne(mappedBy ="usuario", fetch = FetchType.LAZY)
    private CuentaCorrienteCliente cuentaCorrienteCliente;

    public Usuario() {}

    public Usuario(Integer id, EntityType entityType, Date creationDate, Date deletionDate, Boolean isDeleted, String username, String password, String nombre, String apellido, String email, Role role) {
        super(id, entityType, creationDate, deletionDate, isDeleted);
        
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.role = role;
    }
    
    public Usuario(UsuarioDto usuarioDto, Role role ) {
    	this.setId(usuarioDto.getId());
    	this.username = usuarioDto.getUsername();
        this.password = usuarioDto.getPassword();
        this.nombre = usuarioDto.getNombre();
        this.apellido = usuarioDto.getApellido();
        this.email = usuarioDto.getEmail();
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public List<Direccion> getDirecciones(){
    	return direcciones;
    }
    
    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }
}
