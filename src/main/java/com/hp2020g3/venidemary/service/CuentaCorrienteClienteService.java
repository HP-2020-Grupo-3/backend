package com.hp2020g3.venidemary.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp2020g3.venidemary.exception.EntityNotFoundException;
import com.hp2020g3.venidemary.model.CuentaCorrienteCliente;
import com.hp2020g3.venidemary.repository.CuentaCorrienteClienteRepository;

@Service
public class CuentaCorrienteClienteService {
	
	@Autowired
	private CuentaCorrienteClienteRepository cuentaCorrienteClienteRepository;
	
	public Iterable<CuentaCorrienteCliente> findAll() {
        
        return cuentaCorrienteClienteRepository.findAll();
                        
    }
	
	public Optional<CuentaCorrienteCliente> findById(Integer id) {
        
		return cuentaCorrienteClienteRepository.findById(id);
    	
    }
	
	public Boolean deleteById(Integer id) {
    	Optional<CuentaCorrienteCliente> cuentaCorrienteCliente = cuentaCorrienteClienteRepository.findById(id);
    	    	
    	if (cuentaCorrienteCliente.isPresent()) {
    		cuentaCorrienteClienteRepository.deleteById(id);
            return true;
        } else {
        	throw new EntityNotFoundException(String.format("La cuenta corriente %d no existe.", id));
            
        }
    }
	
	public CuentaCorrienteCliente update (CuentaCorrienteCliente newCuentaCorrienteCliente) {
		
		Optional<CuentaCorrienteCliente> cuentaCorrienteCliente = cuentaCorrienteClienteRepository.findById(newCuentaCorrienteCliente.getId());
		
		if (cuentaCorrienteCliente.isPresent()) {
			cuentaCorrienteCliente.get().setFechaCreacion(newCuentaCorrienteCliente.getFechaCreacion());
			cuentaCorrienteCliente.get().setIsAprobada(newCuentaCorrienteCliente.getIsAprobada());
			cuentaCorrienteCliente.get().setIsDeleted(newCuentaCorrienteCliente.getIsDeleted());
			cuentaCorrienteCliente.get().setFechaDeletion(newCuentaCorrienteCliente.getFechaDeletion());
			cuentaCorrienteCliente.get().setUsuario(newCuentaCorrienteCliente.getUsuario());
			cuentaCorrienteCliente.get().setEstadosCuentaCorriente(newCuentaCorrienteCliente.getEstadosCuentaCorriente());
			return cuentaCorrienteClienteRepository.save(cuentaCorrienteCliente.get());
			 
		}
		throw new EntityNotFoundException(String.format("El estado de cuenta corriente %d no existe.", newCuentaCorrienteCliente.getId()));
	}
	
	public CuentaCorrienteCliente save (CuentaCorrienteCliente newCuentaCorrienteCliente) {
		return cuentaCorrienteClienteRepository.save(newCuentaCorrienteCliente);
	}
	
	public CuentaCorrienteCliente getBaseDto() {
		return new CuentaCorrienteCliente();
	}
}
