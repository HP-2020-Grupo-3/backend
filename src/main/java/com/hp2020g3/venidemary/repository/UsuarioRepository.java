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
	
	@Query (value= "select * from usuario u inner join entity e on u.entityId = e.id inner join role r on u.roleId = r.id left join cuentaCorrienteCliente ccc on u.entityId = ccc.usuarioEntityId where r.id = 3 and ccc.usuarioEntityId is null", nativeQuery = true)
	Iterable<Usuario> findValidUsersForCC();
}
