package com.hp2020g3.venidemary.repository;

import com.hp2020g3.venidemary.model.Rubro;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RubroRepository extends CrudRepository<Rubro, Integer>{

	Optional<Rubro> findByNombre(String nombre);
	
	
}

