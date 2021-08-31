package com.hp2020g3.venidemary.repository;

import com.hp2020g3.venidemary.model.LineaComprobantePagoInterface;
import org.springframework.data.repository.CrudRepository;
import com.hp2020g3.venidemary.model.LineaVentaCuentaCorriente;

import java.util.List;

public interface LineaVentaCuentaCorrienteRepository extends CrudRepository<LineaVentaCuentaCorriente, Integer> {

    List<LineaComprobantePagoInterface> findAllByComprobantePagoId(Integer id);
}
