package com.hp2020g3.venidemary.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp2020g3.venidemary.model.Descuento;
import com.hp2020g3.venidemary.repository.DescuentoRepository;

@Service
public class DescuentoService {
	
	@Autowired
	DescuentoRepository descuentoRepository;
	
	public Iterable<Descuento> findAll() {
        
        return descuentoRepository.findAll();
	                        
    }
	
	public Optional<Descuento> findById(Integer id) {
        return descuentoRepository.findById(id);
    	
    }
	
	public Descuento save(Descuento descuento) {
		return descuentoRepository.save(descuento);
	}
	
	public Descuento update(Descuento newDescuento) {
        Optional<Descuento> descuento =  this.findById(newDescuento.getId());

        if (descuento.isPresent()) {
            descuento.get().setValor(newDescuento.getValor());
            descuento.get().setIsHabilitado(newDescuento.getIsHabilitado());
            return this.save(descuento.get());
        } else {
            // TODO: Esto deberia tirar un error de que el descuento que intentas actualizar no existe.
            newDescuento.setId(null);
            return this.save(newDescuento);
        }
    }

    public Boolean deleteById(Integer id) {
    	Optional<Descuento> descuento = descuentoRepository.findById(id);
    	
    	if (descuento.isPresent()) {
            descuentoRepository.delete(descuento.get());
            return true;
        } else {
            // TODO: Esto deberia tirar un error de que no existe el ID de articulo a eliminar
            return false;
        }
    }
	
public Descuento getBaseDto() {
    	
    	Descuento newDescuento = new Descuento();
        return newDescuento;
    }

}
