package com.hp2020g3.venidemary.service;

import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp2020g3.venidemary.model.Articulo;
import com.hp2020g3.venidemary.model.Precio;
import com.hp2020g3.venidemary.repository.PrecioRepository;

@Service
public class PrecioService {
	
	@Autowired
	PrecioRepository precioRepository;
	
	public Iterable<Precio> findAll() {
        
        return precioRepository.findAll();
	                        
    }
	
	public Optional<Precio> findById(Integer id) {
        return precioRepository.findById(id);
    	
    }
	
	public Precio save(Precio precio) {
		return precioRepository.save(precio);
	}
		
	public Precio save(Precio precio, Articulo articulo) {
		precio.setArticulo(articulo);
		return precioRepository.save(precio);
	}
	
	public Precio update(Precio newPrecio) {
        Optional<Precio> precio =  this.findById(newPrecio.getId());

        if (precio.isPresent()) {
            precio.get().setValor(newPrecio.getValor());
            precio.get().setFecha(newPrecio.getFecha());
            precio.get().setArticulo(newPrecio.getArticulo());
            return this.save(precio.get());
        } else {
            // TODO: Esto deberia tirar un error de que el precio que intentas actualizar no existe.
            newPrecio.setId(null);
            return this.save(newPrecio);
        }
    }

    public Boolean deleteById(Integer id) {
    	Optional<Precio> precio = precioRepository.findById(id);
    	
    	if (precio.isPresent()) {
            precioRepository.delete(precio.get());
            return true;
        } else {
            // TODO: Esto deberia tirar un error de que no existe el ID de articulo a eliminar
            return false;
        }
    }
	
public Precio getBaseDto() {
    	
    	Precio newPrecio = new Precio();
    	Date fecha = new Date();
    	newPrecio.setFecha(fecha);
        return newPrecio;
    }

}
