package com.hp2020g3.venidemary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.hp2020g3.venidemary.model.CuentaCorrienteCliente;

public interface CuentaCorrienteClienteRepository extends CrudRepository<CuentaCorrienteCliente, Integer> {
	
	Iterable<CuentaCorrienteCliente> findByIsAprobada(Boolean isAprobada);
	
	Iterable<CuentaCorrienteCliente> findByIsDeleted(Boolean isDeleted);
	
	Iterable<CuentaCorrienteCliente> findByIsAprobadaAndIsDeleted(Boolean isAprobada, Boolean isDeleted);
	
	@Query (value= "SELECT * \r\n"
			+ "FROM cuentaCorrienteCliente \r\n"
			+ "WHERE cuentaCorrienteCliente.usuarioEntityId = ?1", nativeQuery = true)
	Optional<CuentaCorrienteCliente> findByUsuarioEntityId(Integer id);

}
