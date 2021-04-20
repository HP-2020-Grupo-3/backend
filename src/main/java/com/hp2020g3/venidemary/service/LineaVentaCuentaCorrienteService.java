package com.hp2020g3.venidemary.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp2020g3.venidemary.exception.EntityNotFoundException;
import com.hp2020g3.venidemary.model.LineaVentaCuentaCorriente;
import com.hp2020g3.venidemary.model.PagoCuentaCorriente;
import com.hp2020g3.venidemary.repository.LineaVentaCuentaCorrienteRepository;


@Service
public class LineaVentaCuentaCorrienteService {
	@Autowired
	private LineaVentaCuentaCorrienteRepository lineaVentaCuentaCorrienteRepository;
	
	public Iterable<LineaVentaCuentaCorriente> findAll() {
        
        return lineaVentaCuentaCorrienteRepository.findAll();
                        
    }
	
	public Optional<LineaVentaCuentaCorriente> findById(Integer id) {
        
		return lineaVentaCuentaCorrienteRepository.findById(id);
    	
    }
	
	public Boolean deleteById(Integer id) {
    	Optional<LineaVentaCuentaCorriente> lineaVentaCuentaCorriente = lineaVentaCuentaCorrienteRepository.findById(id);
    	    	
    	if (lineaVentaCuentaCorriente.isPresent()) {
    		lineaVentaCuentaCorrienteRepository.deleteById(id);
            return true;
        } else {
        	throw new EntityNotFoundException(String.format("Línea de venta %d no existe.", id));
            
        }
    }
	
	public LineaVentaCuentaCorriente update (LineaVentaCuentaCorriente newLineaVentaCuentaCorriente) {
		
		Optional<LineaVentaCuentaCorriente> lineaVentaCuentaCorriente = lineaVentaCuentaCorrienteRepository.findById(newLineaVentaCuentaCorriente.getId());
		
		if (lineaVentaCuentaCorriente.isPresent()) {
			lineaVentaCuentaCorriente.get().setCantidad(newLineaVentaCuentaCorriente.getCantidad());
			lineaVentaCuentaCorriente.get().setPrecio(newLineaVentaCuentaCorriente.getPrecio());
			return lineaVentaCuentaCorrienteRepository.save(lineaVentaCuentaCorriente.get());
			 
		}
		throw new EntityNotFoundException(String.format("Linea de Venta de Cuenta Corriente %d no existe.", newLineaVentaCuentaCorriente.getId()));
	}
	
	public LineaVentaCuentaCorriente save (LineaVentaCuentaCorriente newLineaVentaCuentaCorriente) {
		return lineaVentaCuentaCorrienteRepository.save(newLineaVentaCuentaCorriente);
	}
	public LineaVentaCuentaCorriente getBaseDto() {
        return new LineaVentaCuentaCorriente();
    }
}
