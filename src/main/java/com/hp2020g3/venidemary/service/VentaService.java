package com.hp2020g3.venidemary.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp2020g3.venidemary.model.Venta;
import com.hp2020g3.venidemary.repository.VentaRepository;

@Service
public class VentaService {
	
	@Autowired
	VentaRepository ventaRepository;
	
	public Iterable<Venta> findAll() {
        
        return ventaRepository.findAll();
	                        
    }
	
	public Optional<Venta> findById(Integer id) {
        return ventaRepository.findById(id);
    	
    }
	
	public Venta save(Venta venta) {
		return ventaRepository.save(venta);
	}
	
	public Venta update(Venta newVenta) {
        Optional<Venta> venta =  this.findById(newVenta.getId());

        if (venta.isPresent()) {
            venta.get().setFecha(newVenta.getFecha());
            venta.get().setNumeroComprobante(newVenta.getNumeroComprobante());
            venta.get().setIsEntregada(newVenta.getIsEntregada());
            venta.get().setNota(newVenta.getNota());
            return this.save(venta.get());
        } else {
            // TODO: Esto deberia tirar un error de que el venta que intentas actualizar no existe.
            newVenta.setId(null);
            return this.save(newVenta);
        }
    }

    public Boolean deleteById(Integer id) {
    	Optional<Venta> venta = ventaRepository.findById(id);
    	
    	if (venta.isPresent()) {
            ventaRepository.delete(venta.get());
            return true;
        } else {
            // TODO: Esto deberia tirar un error de que no existe el ID de articulo a eliminar
            return false;
        }
    }
	
public Venta getBaseDto() {
    	
    	Venta newVenta = new Venta();
        return newVenta;
    }

}
