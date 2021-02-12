package com.hp2020g3.venidemary.repository;

import org.springframework.data.repository.CrudRepository;
import com.hp2020g3.venidemary.model.Articulo;

public interface ArticuloRepository extends CrudRepository<Articulo, Integer> {
	
	Iterable<Articulo> findAllByIsDeleted(Boolean isDeleted);
	
}
