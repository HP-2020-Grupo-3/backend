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
	
	@Query (value= "SELECT * \r\n"
			+ "FROM usuario u \r\n"
			+ "INNER JOIN entity e \r\n"
			+ "    ON u.entityId = e.id \r\n"
			+ "INNER JOIN role r \r\n"
			+ "    ON u.roleId = r.id \r\n"
			+ "LEFT JOIN cuentaCorrienteCliente ccc\r\n"
			+ "    ON u.entityId = ccc.usuarioEntityId \r\n"
			+ "WHERE r.id = 3 AND (ccc.usuarioEntityId IS NULL OR ccc.isDeleted = 1)", nativeQuery = true)
	Iterable<Usuario> findValidUsersForCC();
}
