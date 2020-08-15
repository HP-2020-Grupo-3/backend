package com.hp2020g3.venidemary.model;

import javax.persistence.*;
import java.util.List;

@Entity(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @ManyToMany
    @JoinTable(name = "rPermissionRole", joinColumns = @JoinColumn(name = "permissionId"),
        inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Permission> permissions;

    public Role() {}

    public Role(Integer id, String name, List<Permission> permissions) {
        this.id = id;
        this.name = name;
        this.permissions = permissions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
