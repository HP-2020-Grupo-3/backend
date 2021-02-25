package com.hp2020g3.venidemary.security;

import com.hp2020g3.venidemary.model.Role;
import com.hp2020g3.venidemary.model.Usuario;
import com.hp2020g3.venidemary.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService {

    @Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final Optional<Usuario> retrievedUser = usuarioRepository.findByUsername(username);
		if (!retrievedUser.isPresent()) {
			throw new  UsernameNotFoundException("Invalid username or password");
		}

		return new AuthenticatedUser(retrievedUser.get());
	}

}
