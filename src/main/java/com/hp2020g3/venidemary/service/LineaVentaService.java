package com.hp2020g3.venidemary.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp2020g3.venidemary.model.Articulo;
import com.hp2020g3.venidemary.model.LineaVenta;
import com.hp2020g3.venidemary.model.Precio;
import com.hp2020g3.venidemary.repository.LineaVentaRepository;

@Service
public class LineaVentaService {

	@Autowired
	LineaVentaRepository lineaVentaRepository;
	
	public Iterable<LineaVenta> findAll() {
        
        return lineaVentaRepository.findAll();
	                        
    }
	
	public Optional<LineaVenta> findById(Integer id) {
        return lineaVentaRepository.findById(id);
    	
    }
	
	public LineaVenta save(LineaVenta lineaVenta) {
		return lineaVentaRepository.save(lineaVenta);
	}
		
	public LineaVenta save(LineaVenta lineaVenta, Articulo articulo, Precio precio) {
		lineaVenta.setArticulo(articulo);
		lineaVenta.setPrecio(precio);
		return lineaVentaRepository.save(lineaVenta);
	}
	
	public LineaVenta update(LineaVenta newLineaVenta) {
        Optional<LineaVenta> lineaVenta =  this.findById(newLineaVenta.getId());

        if (lineaVenta.isPresent()) {
            lineaVenta.get().setCantidad(newLineaVenta.getCantidad());
            lineaVenta.get().setArticulo(newLineaVenta.getArticulo());
            lineaVenta.get().setPrecio(newLineaVenta.getPrecio());
            return this.save(lineaVenta.get());
        } else {
            // TODO: Esto deberia tirar un error de que la lineaVenta que intentas actualizar no existe.
            newLineaVenta.setId(null);
            return this.save(newLineaVenta);
        }
    }

    public Boolean deleteById(Integer id) {
    	Optional<LineaVenta> lineaVenta = lineaVentaRepository.findById(id);
    	
    	if (lineaVenta.isPresent()) {
            lineaVentaRepository.delete(lineaVenta.get());
            return true;
        } else {
            // TODO: Esto deberia tirar un error de que no existe el ID de articulo a eliminar
            return false;
        }
    }
	
public LineaVenta getBaseDto() {
    	
    	LineaVenta newLineaVenta = new LineaVenta();
        return newLineaVenta;
    }

}