package com.hp2020g3.venidemary.repository;

import com.hp2020g3.venidemary.model.Usuario;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    //Optional<Usuario> findByNombre(String nombre);
	
	Optional<Usuario> findByUsername(String username);
	
	Iterable<Usuario> findByIsDeleted(Boolean isDeleted);
	
	Iterable<Usuario> findByRoleId(Integer roleId);
	
	@Query (value= "SELECT * "
			+ "FROM usuario u "
			+ "INNER JOIN entity e "
			+ "    ON u.entityId = e.id "
			+ "INNER JOIN role r "
			+ "    ON u.roleId = r.id "
			+ "LEFT JOIN cuentaCorrienteCliente ccc "
			+ "    ON u.entityId = ccc.usuarioEntityId "
			+ "WHERE r.id = 3 "
			+ "AND (ccc.usuarioEntityId IS NULL OR ccc.isDeleted = 1)"
			+ "AND e.isDeleted = 0", nativeQuery = true)
	Iterable<Usuario> findValidUsersForCC();
}
