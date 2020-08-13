package com.hp2020g3.venidemary.repository;

import java.util.List;
import java.util.Optional;
import com.hp2020g3.venidemary.model.Provincia;
import org.springframework.data.repository.CrudRepository;

public interface ProvinciaRepository extends CrudRepository<Provincia, Integer>{

    List<Provincia> findByNombre(String name);

}

