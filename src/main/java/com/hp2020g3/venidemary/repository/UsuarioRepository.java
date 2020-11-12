package com.hp2020g3.venidemary.repository;

import com.hp2020g3.venidemary.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	
	Iterable<Usuario> findByIsDeleted(Boolean isDeleted);

}
