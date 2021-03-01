package com.hp2020g3.venidemary.service;

import java.util.Optional;

import com.hp2020g3.venidemary.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp2020g3.venidemary.model.TipoEntrega;
import com.hp2020g3.venidemary.repository.TipoEntregaRepository;

@Service
public class TipoEntregaService {
	
	@Autowired
	TipoEntregaRepository tipoEntregaRepository;
	
	public Iterable<TipoEntrega> findAll() {
        
        return tipoEntregaRepository.findAll();
	                        
    }
	
	public Optional<TipoEntrega> findById(Integer id) {
        return tipoEntregaRepository.findById(id);
    	
    }
	
	public TipoEntrega save(TipoEntrega tipoEntrega) {
		return tipoEntregaRepository.save(tipoEntrega);
	}
	
	public TipoEntrega update(TipoEntrega newTipoEntrega) {
        Optional<TipoEntrega> tipoEntrega =  this.findById(newTipoEntrega.getId());

        if (tipoEntrega.isPresent()) {
            tipoEntrega.get().setNombre(newTipoEntrega.getNombre());
            return this.save(tipoEntrega.get());
        } else {
            // TODO: Esto deberia tirar un error de que el tipoEntrega que intentas actualizar no existe.
            newTipoEntrega.setId(null);
            return this.save(newTipoEntrega);
        }
    }

    public Boolean deleteById(Integer id) {
    	Optional<TipoEntrega> tipoEntrega = tipoEntregaRepository.findById(id);
    	
    	if (tipoEntrega.isPresent()) {
            tipoEntregaRepository.delete(tipoEntrega.get());
            return true;
        } else {
            // TODO: Esto deberia tirar un error de que no existe el ID de articulo a eliminar
            return false;
        }
    }

    public TipoEntrega getBaseDto() {
    	
    	TipoEntrega newTipoEntrega = new TipoEntrega();
        return newTipoEntrega;
    }

    public TipoEntrega getDefault() {
	    return this.findById(Constants.DEFAULT_TIPO_ENTREGA_ID).get();
    }


}
