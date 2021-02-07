package com.hp2020g3.venidemary.security;

import com.hp2020g3.venidemary.model.Role;
import com.hp2020g3.venidemary.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.HashSet;
import java.util.Set;

public class AuthenticatedUser extends User {

    private Usuario usuario;

    public AuthenticatedUser(Usuario user) {
        super(user.getNombre(), user.getPassword(), getAuthorities(user));
        this.usuario = user;
    }

	private static Set<? extends GrantedAuthority> getAuthorities(Usuario retrievedUser) {
		Role role = retrievedUser.getRole();
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		return authorities;
	}

    public Usuario getUsuario() {
        return usuario;
    }

}
