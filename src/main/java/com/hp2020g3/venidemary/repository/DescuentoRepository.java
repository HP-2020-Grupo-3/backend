package com.hp2020g3.venidemary.repository;

import org.springframework.data.repository.CrudRepository;
import com.hp2020g3.venidemary.model.Descuento;

public interface DescuentoRepository extends CrudRepository<Descuento, Integer> {

    Iterable<Descuento> findAllByIsHabilitado(Boolean isHabilitado);
}
