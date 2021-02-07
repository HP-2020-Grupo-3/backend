package com.hp2020g3.venidemary.model;

import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "usuario")
@PrimaryKeyJoinColumn(name = "entityId")
public class Usuario extends BaseEntity {

    private String nombre;
    private String password;
    private String email;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    public Usuario() {}

    public Usuario(Integer id, EntityType entityType, Date creationDate, Date deletionDate, Boolean isDeleted, String nombre, String password, String email, Role role) {
        super(id, entityType, creationDate, deletionDate, isDeleted);
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
