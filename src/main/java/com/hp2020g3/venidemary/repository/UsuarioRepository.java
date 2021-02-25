package com.hp2020g3.venidemary.repository;

import com.hp2020g3.venidemary.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    //Optional<Usuario> findByNombre(String nombre);
	
	Optional<Usuario> findByUsername(String username);
	
	Iterable<Usuario> findByIsDeleted(Boolean isDeleted);
}
