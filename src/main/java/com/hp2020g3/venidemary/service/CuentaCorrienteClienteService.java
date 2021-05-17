package com.hp2020g3.venidemary.service;

import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp2020g3.venidemary.dto.CuentaCorrienteClienteDto;
import com.hp2020g3.venidemary.exception.EntityNotFoundException;
import com.hp2020g3.venidemary.model.CuentaCorrienteCliente;
import com.hp2020g3.venidemary.repository.CuentaCorrienteClienteRepository;

@Service
public class CuentaCorrienteClienteService {
	
	@Autowired
	private CuentaCorrienteClienteRepository cuentaCorrienteClienteRepository;
	Integer cantidadAprobacion = 0;
	
	public Iterable<CuentaCorrienteClienteDto> findAll() {
        
		cantidadAprobacion = 0;
		Iterable<CuentaCorrienteCliente> cuentaCorrienteClientes = cuentaCorrienteClienteRepository.findByIsAprobadaAndIsDeleted(true, false);
		Iterable<CuentaCorrienteCliente> cuentasCorrientesPendientesAprobacion = cuentaCorrienteClienteRepository.findByIsAprobadaAndIsDeleted(false, false);
		Iterator<CuentaCorrienteCliente> iterator = cuentasCorrientesPendientesAprobacion.iterator();
		
		while (iterator.hasNext()) {
			iterator.next();
			cantidadAprobacion++;
		}
				
		return StreamSupport.stream(cuentaCorrienteClientes.spliterator(), false)
                .map(cuentaCorrienteCliente -> new CuentaCorrienteClienteDto(cuentaCorrienteCliente, cantidadAprobacion))
                .collect(Collectors.toList());
		                      
    }
	
	public Iterable<CuentaCorrienteClienteDto> findAllNotAprobada() {
        
		Iterable<CuentaCorrienteCliente> cuentaCorrienteClientes = cuentaCorrienteClienteRepository.findByIsAprobadaAndIsDeleted(false, false);
		
		return StreamSupport.stream(cuentaCorrienteClientes.spliterator(), false)
                .map(cuentaCorrienteCliente -> new CuentaCorrienteClienteDto(cuentaCorrienteCliente, 0))
                .collect(Collectors.toList());
       
	}
	
	public CuentaCorrienteClienteDto findById(Integer id) {
		
		Optional<CuentaCorrienteCliente> cuentaCorrienteCliente = cuentaCorrienteClienteRepository.findById(id);
		
		if (cuentaCorrienteCliente.isPresent()) {
			return new CuentaCorrienteClienteDto(cuentaCorrienteCliente.get(), 0);
		} else {
            throw new EntityNotFoundException(String.format("La Cuenta Corriente %d no existe.", id));
        }
    	
    }
	
	public Boolean deleteById(Integer id) {
    	Optional<CuentaCorrienteCliente> cuentaCorrienteCliente = cuentaCorrienteClienteRepository.findById(id);
    	    	
    	if (cuentaCorrienteCliente.isPresent()) {
    		cuentaCorrienteCliente.get().setIsDeleted(true);
    		cuentaCorrienteClienteRepository.save(cuentaCorrienteCliente.get());
    		//cuentaCorrienteClienteRepository.deleteById(id);
            return true;
        } else {
        	throw new EntityNotFoundException(String.format("La cuenta corriente %d no existe.", id));
            
        }
    }
	
	public CuentaCorrienteCliente update (CuentaCorrienteClienteDto newCuentaCorrienteCliente) {
		
		Optional<CuentaCorrienteCliente> cuentaCorrienteCliente = cuentaCorrienteClienteRepository.findById(newCuentaCorrienteCliente.getId());
		
		if (cuentaCorrienteCliente.isPresent()) {
			cuentaCorrienteCliente.get().setIsAprobada(newCuentaCorrienteCliente.getIsAprobada());
			cuentaCorrienteCliente.get().setIsDeleted(newCuentaCorrienteCliente.getIsDeleted());
			//cuentaCorrienteCliente.get().setEstadosCuentaCorriente(newCuentaCorrienteCliente.getEstadosCuentaCorriente());
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
