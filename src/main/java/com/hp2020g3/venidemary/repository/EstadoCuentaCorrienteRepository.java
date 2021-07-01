package com.hp2020g3.venidemary.repository;

import org.springframework.data.repository.CrudRepository;
import com.hp2020g3.venidemary.model.EstadoCuentaCorriente;

public interface EstadoCuentaCorrienteRepository extends CrudRepository<EstadoCuentaCorriente, Integer> {

    EstadoCuentaCorriente findByCuentaCorrienteClienteId(Integer cuentaConrrienteClienteId);

    EstadoCuentaCorriente findByCuentaCorrienteClienteIdAndArticuloId(Integer cuentaConrrienteClienteId, Integer id);
}
