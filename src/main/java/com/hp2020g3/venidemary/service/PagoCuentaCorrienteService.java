package com.hp2020g3.venidemary.service;

import java.util.List;
import java.util.Optional;

import com.hp2020g3.venidemary.model.LineaComprobantePagoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp2020g3.venidemary.exception.EntityNotFoundException;
import com.hp2020g3.venidemary.model.PagoCuentaCorriente;
import com.hp2020g3.venidemary.repository.PagoCuentaCorrienteRepository;

@Service
public class PagoCuentaCorrienteService {
	
	@Autowired
	private PagoCuentaCorrienteRepository pagoCuentaCorrienteRepository;
	
	public Iterable<PagoCuentaCorriente> findAll() {
        
        return pagoCuentaCorrienteRepository.findAll();
                        
    }

    public List<LineaComprobantePagoInterface> findAllByComprobantePagoId(Integer id) {

        return pagoCuentaCorrienteRepository.findAllByComprobantePagoId(id);

    }

	public Optional<PagoCuentaCorriente> findById(Integer id) {
        
		return pagoCuentaCorrienteRepository.findById(id);
    	
    }
	
	public Boolean deleteById(Integer id) {
    	Optional<PagoCuentaCorriente> pagoCuentaCorriente = pagoCuentaCorrienteRepository.findById(id);
    	    	
    	if (pagoCuentaCorriente.isPresent()) {
    		pagoCuentaCorrienteRepository.deleteById(id);
            return true;
        } else {
        	throw new EntityNotFoundException(String.format("El pago %d no existe.", id));
            
        }
    }
	
	public PagoCuentaCorriente update (PagoCuentaCorriente newPagoCuentaCorriente) {
		
		Optional<PagoCuentaCorriente> pagoCuentaCorriente = pagoCuentaCorrienteRepository.findById(newPagoCuentaCorriente.getId());
		
		if (pagoCuentaCorriente.isPresent()) {
			pagoCuentaCorriente.get().setCantidad(newPagoCuentaCorriente.getCantidad());
			pagoCuentaCorriente.get().setPrecio(newPagoCuentaCorriente.getPrecio());
			pagoCuentaCorriente.get().setComprobantePago(newPagoCuentaCorriente.getComprobantePago());
			return pagoCuentaCorrienteRepository.save(pagoCuentaCorriente.get());
			 
		}
		throw new EntityNotFoundException(String.format("El pago %d no existe.", newPagoCuentaCorriente.getId()));
	}
	
	public PagoCuentaCorriente save (PagoCuentaCorriente newPagoCuentaCorriente) {
		return pagoCuentaCorrienteRepository.save(newPagoCuentaCorriente);
	}
	
	public PagoCuentaCorriente getBaseDto() {
        return new PagoCuentaCorriente();
    }
}
