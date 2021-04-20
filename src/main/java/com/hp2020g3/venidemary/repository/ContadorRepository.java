package com.hp2020g3.venidemary.repository;

import org.springframework.data.repository.CrudRepository;
import com.hp2020g3.venidemary.model.Contador;

import java.util.Optional;

public interface ContadorRepository extends CrudRepository<Contador, Integer> {

    Optional<Contador> findByNombre(String nombre);

}