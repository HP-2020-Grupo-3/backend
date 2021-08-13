package com.hp2020g3.venidemary.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.hp2020g3.venidemary.model.Venta;

public interface VentaRepository extends CrudRepository<Venta, Integer>{
	
	Optional<Venta> findByComprobantePagoId(Integer comprobantePagoId);

}
