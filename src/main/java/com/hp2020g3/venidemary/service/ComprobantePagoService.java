package com.hp2020g3.venidemary.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp2020g3.venidemary.model.ComprobantePago;
import com.hp2020g3.venidemary.repository.ComprobantePagoRepository;

@Service
public class ComprobantePagoService {
	
	@Autowired
	ComprobantePagoRepository comprobantePagoRepository;
	
	public Iterable<ComprobantePago> findAll() {
        
        return comprobantePagoRepository.findAll();
	                        
    }
	
	public Optional<ComprobantePago> findById(Integer id) {
        return comprobantePagoRepository.findById(id);
    	
    }
	
	public ComprobantePago save(ComprobantePago comprobantePago) {
		return comprobantePagoRepository.save(comprobantePago);
	}
	
	public ComprobantePago update(ComprobantePago newComprobantePago) {
        Optional<ComprobantePago> comprobantePago =  this.findById(newComprobantePago.getId());

        if (comprobantePago.isPresent()) {
            comprobantePago.get().setFecha(newComprobantePago.getFecha());
            comprobantePago.get().setNumeroComprobante(newComprobantePago.getNumeroComprobante());
            comprobantePago.get().setNumeroFactura(newComprobantePago.getNumeroFactura());
            comprobantePago.get().setNota(newComprobantePago.getNota());
            return this.save(comprobantePago.get());
        } else {
            // TODO: Esto deberia tirar un error de que el comprobantePago que intentas actualizar no existe.
            newComprobantePago.setId(null);
            return this.save(newComprobantePago);
        }
    }

    public Boolean deleteById(Integer id) {
    	Optional<ComprobantePago> comprobantePago = comprobantePagoRepository.findById(id);
    	
    	if (comprobantePago.isPresent()) {
            comprobantePagoRepository.delete(comprobantePago.get());
            return true;
        } else {
            // TODO: Esto deberia tirar un error de que no existe el ID de articulo a eliminar
            return false;
        }
    }
	
public ComprobantePago getBaseDto() {
    	
    	ComprobantePago newComprobantePago = new ComprobantePago();
        return newComprobantePago;
    }

}
