package com.hp2020g3.venidemary.repository;

import java.util.List;
import java.util.Optional;
import com.hp2020g3.venidemary.model.Ciudad;
import org.springframework.data.repository.CrudRepository;

public interface CiudadRepository extends CrudRepository<Ciudad, Integer>{

    List<Ciudad> findByNombre(String name);

}

