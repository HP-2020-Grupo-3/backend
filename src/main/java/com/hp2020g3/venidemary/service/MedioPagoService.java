package com.hp2020g3.venidemary.service;

import java.util.Optional;

import com.hp2020g3.venidemary.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp2020g3.venidemary.model.MedioPago;
import com.hp2020g3.venidemary.repository.MedioPagoRepository;

@Service
public class MedioPagoService {
	
	@Autowired
	MedioPagoRepository medioPagoRepository;
	
	public Iterable<MedioPago> findAll() {
        
        return medioPagoRepository.findAll();
	                        
    }
	
	public Optional<MedioPago> findById(Integer id) {
        return medioPagoRepository.findById(id);
    	
    }
	
	public MedioPago save(MedioPago medioPago) {
		return medioPagoRepository.save(medioPago);
	}
	
	public MedioPago update(MedioPago newMedioPago) {
        Optional<MedioPago> medioPago =  this.findById(newMedioPago.getId());

        if (medioPago.isPresent()) {
            medioPago.get().setNombre(newMedioPago.getNombre());
            return this.save(medioPago.get());
        } else {
            // TODO: Esto deberia tirar un error de que el medioPago que intentas actualizar no existe.
            newMedioPago.setId(null);
            return this.save(newMedioPago);
        }
    }

    public Boolean deleteById(Integer id) {
    	Optional<MedioPago> medioPago = medioPagoRepository.findById(id);
    	
    	if (medioPago.isPresent()) {
            medioPagoRepository.delete(medioPago.get());
            return true;
        } else {
            // TODO: Esto deberia tirar un error de que no existe el ID de articulo a eliminar
            return false;
        }
    }
	
    public MedioPago getBaseDto() {
    	
    	MedioPago newMedioPago = new MedioPago();
        return newMedioPago;
    }

    public MedioPago getDefault() {
	    return this.findById(Constants.DEFAULT_MEDIO_PAGO_ID).get();
    }

}