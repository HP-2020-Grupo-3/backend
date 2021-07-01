package com.hp2020g3.venidemary.service;

import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.hp2020g3.venidemary.dto.CuentaCorrienteClientesDto;
import com.hp2020g3.venidemary.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp2020g3.venidemary.dto.CuentaCorrienteClienteDto;
import com.hp2020g3.venidemary.model.CuentaCorrienteCliente;
import com.hp2020g3.venidemary.model.Usuario;
import com.hp2020g3.venidemary.repository.CuentaCorrienteClienteRepository;
import com.hp2020g3.venidemary.repository.UsuarioRepository;


@Service
public class CuentaCorrienteClienteService {
	
	@Autowired
	private CuentaCorrienteClienteRepository cuentaCorrienteClienteRepository;
	
	@Autowired
	private UsuarioService usuarioService;
		
	Integer cantidadAprobacion = 0;
	
	public CuentaCorrienteClientesDto findAll() {
        CuentaCorrienteClientesDto mainDto = new CuentaCorrienteClientesDto();

		cantidadAprobacion = 0;
		Iterable<CuentaCorrienteCliente> cuentaCorrienteClientes = cuentaCorrienteClienteRepository.findByIsAprobadaAndIsDeleted(true, false);
		Iterable<CuentaCorrienteCliente> cuentasCorrientesPendientesAprobacion = cuentaCorrienteClienteRepository.findByIsAprobadaAndIsDeleted(false, false);
		Iterator<CuentaCorrienteCliente> iterator = cuentasCorrientesPendientesAprobacion.iterator();
		
		while (iterator.hasNext()) {
			iterator.next();
			cantidadAprobacion++;
		}

		mainDto.setCantidadAprobacion(cantidadAprobacion);
		mainDto.setCuentaCorrienteClienteDtos(StreamSupport.stream(cuentaCorrienteClientes.spliterator(), false)
                .map(cuentaCorrienteCliente -> new CuentaCorrienteClienteDto(cuentaCorrienteCliente))
                .collect(Collectors.toList()));

		return mainDto;
    }

    public Iterable<CuentaCorrienteCliente> findByIsAprobadaAndIsDeleted(Boolean isAprobada, Boolean isDeleted) {
		return cuentaCorrienteClienteRepository.findByIsAprobadaAndIsDeleted(isAprobada, isDeleted);
	}
	
	public Iterable<CuentaCorrienteClienteDto> findAllNotAprobada() {
        
		Iterable<CuentaCorrienteCliente> cuentaCorrienteClientes = cuentaCorrienteClienteRepository.findByIsAprobadaAndIsDeleted(false, false);
		
		return StreamSupport.stream(cuentaCorrienteClientes.spliterator(), false)
                .map(cuentaCorrienteCliente -> new CuentaCorrienteClienteDto(cuentaCorrienteCliente))
                .collect(Collectors.toList());
       
	}
	
	public CuentaCorrienteCliente findById(Integer id) {
		
		Optional<CuentaCorrienteCliente> cuentaCorrienteCliente = cuentaCorrienteClienteRepository.findById(id);
		
		if (cuentaCorrienteCliente.isPresent()) {
			return cuentaCorrienteCliente.get();
		} else {
            throw new EntityNotFoundException(String.format("La Cuenta Corriente %d no existe.", id));
        }
    	
    }
    public CuentaCorrienteClienteDto findDtoById(Integer id) {
		return new CuentaCorrienteClienteDto(this.findById(id));
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
		throw new EntityNotFoundException(String.format("La cuenta corriente %d no existe.", newCuentaCorrienteCliente.getId()));
	}
	
	public CuentaCorrienteCliente save (CuentaCorrienteClienteDto cuentaCorrienteClienteDto) {
		
		Optional<CuentaCorrienteCliente> existCCforUser = cuentaCorrienteClienteRepository.findByUsuarioEntityId(cuentaCorrienteClienteDto.getUsuarioId());
		
		if (existCCforUser.isPresent()) {
			existCCforUser.get().setIsAprobada(false);
			existCCforUser.get().setIsDeleted(false);
			existCCforUser.get().setFechaDeletion(null);
			return cuentaCorrienteClienteRepository.save(existCCforUser.get());	
		} else {
			CuentaCorrienteCliente cc = new CuentaCorrienteCliente();
			Optional<Usuario> usuario = usuarioService.findById(cuentaCorrienteClienteDto.getUsuarioId());
			cc.setFechaCreacion(cuentaCorrienteClienteDto.getFechaCreacion());
			cc.setIsAprobada(cuentaCorrienteClienteDto.getIsAprobada());
			cc.setIsDeleted(cuentaCorrienteClienteDto.getIsDeleted());
			cc.setFechaDeletion(null);
			if (usuario.isPresent()) {
				cc.setUsuario(usuario.get());
				return cuentaCorrienteClienteRepository.save(cc);
			} else {
				throw new EntityNotFoundException(String.format("El usuario %d no existe.", cuentaCorrienteClienteDto.getId()));
			}
		}
	}
	
	public CuentaCorrienteClienteDto getBaseDto() {
		
		Iterable<Usuario> usuarios = usuarioService.findValidUsersForCC();
		
		return new CuentaCorrienteClienteDto(usuarios);
	
	}
}
