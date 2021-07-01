package com.hp2020g3.venidemary.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp2020g3.venidemary.exception.EntityNotFoundException;
import com.hp2020g3.venidemary.model.EstadoCuentaCorriente;
import com.hp2020g3.venidemary.repository.EstadoCuentaCorrienteRepository;

@Service
public class EstadoCuentaCorrienteService {
	
	@Autowired
	private EstadoCuentaCorrienteRepository estadoCuentaCorrienteRepository;
	
	public Iterable<EstadoCuentaCorriente> findAll() {
        
        return estadoCuentaCorrienteRepository.findAll();
                        
    }
	
	public Optional<EstadoCuentaCorriente> findById(Integer id) {
        
		return estadoCuentaCorrienteRepository.findById(id);
    	
    }
	
	public Boolean deleteById(Integer id) {
    	Optional<EstadoCuentaCorriente> estadoCuentaCorriente = estadoCuentaCorrienteRepository.findById(id);
    	    	
    	if (estadoCuentaCorriente.isPresent()) {
    		estadoCuentaCorrienteRepository.deleteById(id);
            return true;
        } else {
        	throw new EntityNotFoundException(String.format("El estado de cuenta corriente %d no existe.", id));
            
        }
    }
	
	public EstadoCuentaCorriente update (EstadoCuentaCorriente newEstadoCuentaCorriente) {
		
		Optional<EstadoCuentaCorriente> estadoCuentaCorriente = estadoCuentaCorrienteRepository.findById(newEstadoCuentaCorriente.getId());
		
		if (estadoCuentaCorriente.isPresent()) {
			estadoCuentaCorriente.get().setCantidad(newEstadoCuentaCorriente.getCantidad());
			estadoCuentaCorriente.get().setArticulo(newEstadoCuentaCorriente.getArticulo());
			estadoCuentaCorriente.get().setCuentaCorrienteCliente(newEstadoCuentaCorriente.getCuentaCorrienteCliente());
			estadoCuentaCorriente.get().setLineasVentaCuentaCorriente(newEstadoCuentaCorriente.getLineasVentaCuentaCorriente());
			estadoCuentaCorriente.get().setPagosCuentaCorriente(newEstadoCuentaCorriente.getPagosCuentaCorriente());
			return estadoCuentaCorrienteRepository.save(estadoCuentaCorriente.get());
			 
		}
		throw new EntityNotFoundException(String.format("El estado de cuenta corriente %d no existe.", newEstadoCuentaCorriente.getId()));
	}
	
	public EstadoCuentaCorriente save (EstadoCuentaCorriente newEstadoCuentaCorriente) {
		return estadoCuentaCorrienteRepository.save(newEstadoCuentaCorriente);
	}
	
	public EstadoCuentaCorriente getBaseDto() {
		return new EstadoCuentaCorriente();
	}

    public EstadoCuentaCorriente findByCuentaCorrienteClienteId(Integer cuentaConrrienteClienteId) {
		return estadoCuentaCorrienteRepository.findByCuentaCorrienteClienteId(cuentaConrrienteClienteId);
    }

	public EstadoCuentaCorriente findByCuentaCorrienteClienteIdAndArticuloId(Integer cuentaConrrienteClienteId, Integer id) {
		return estadoCuentaCorrienteRepository.findByCuentaCorrienteClienteIdAndArticuloId(cuentaConrrienteClienteId, id);
	}
}
