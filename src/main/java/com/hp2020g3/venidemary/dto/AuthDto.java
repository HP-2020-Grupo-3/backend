package com.hp2020g3.venidemary.dto;

import com.hp2020g3.venidemary.security.AuthenticatedUser;

import java.util.Date;

public class AuthDto {

    private Integer id;
    private String username;
    private String role;

    private String token;

    public AuthDto() {
    }

    public AuthDto(Integer id, String username, String token) {
        this.id = id;
        this.username = username;
        this.token = token;
    }
    public AuthDto(AuthenticatedUser user, String token) {
        this.id = user.getUsuario().getId();
        this.username = user.getUsuario().getUsername();
        this.role = user.getAuthorities().iterator().next().toString();
        this.token = token;
    }

    public String toJson() {
        return "{" +
            "\"id\": " + this.id.toString() + "," +
            "\"username\": \"" + this.username + "\"," +
            "\"role\": \"" + this.role + "\"," +
            "\"token\": \"" + this.token + "\"" +
        "}";
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
