package com.hp2020g3.venidemary.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp2020g3.venidemary.dto.ArticuloDto;
import com.hp2020g3.venidemary.model.Articulo;
import com.hp2020g3.venidemary.model.Rubro;
import com.hp2020g3.venidemary.repository.ArticuloRepository;
import com.hp2020g3.venidemary.repository.RubroRepository;

@Service
public class ArticuloService {
	
	
	@Autowired
	private ArticuloRepository articuloRepository;
	
	@Autowired
	private RubroRepository rubroRepository;
	
	@Autowired
	private RubroService rubroService;
	
	public Iterable<Articulo> findAll() {
        
        return articuloRepository.findAll();
                        
    }
    
    public Iterable<Articulo> findAllByIsDeleted() {
    	
    	Iterable<Articulo> validArticles = articuloRepository.findAllByIsDeleted(false);
    	return validArticles;
    	
    }

    public Optional<Articulo> findById(Integer id) {
        return articuloRepository.findById(id);
    	
    }
    
    public ArticuloDto findArticuloDtoById(Integer id) {
        
    	return new ArticuloDto(articuloRepository.findById(id), rubroService.findAll());
    }    

        
	public Articulo save(Articulo articulo) {
	    
		if (articulo.getRubro() != null) {
			return articuloRepository.save(articulo);
		} else {
			Optional<Rubro> rubroGenerico = rubroService.findByNombre("GENERICO");
	    		if (rubroGenerico.isPresent()) {
		    	articulo.setRubro(rubroGenerico.get());
		    	return articuloRepository.save(articulo);
	    		} else {
	    			// TODO: Tirar error de que no existe el rol para el articulo
	    			return articulo;
	    		}
	    }     	
        
    }
	
	public Articulo save(Articulo articulo, Rubro rubro) {
		articulo.setRubro(rubro);
		return articuloRepository.save(articulo);
	}

    public Articulo update(Articulo newArticulo) {
        Optional<Articulo> articulo =  this.findById(newArticulo.getId());

        if (articulo.isPresent()) {
            articulo.get().setNombre(newArticulo.getNombre());
            articulo.get().setDescripcion(newArticulo.getDescripcion());
            articulo.get().setImagen(newArticulo.getImagen());
            articulo.get().setStockDeseado(newArticulo.getStockDeseado());
            articulo.get().setStockActual(newArticulo.getStockActual());
            articulo.get().setRubro(newArticulo.getRubro());
            return this.save(articulo.get());
        } else {
            // TODO: Esto deberia tirar un error de que rubro que intetas actuializar no existe.
            newArticulo.setId(null);
            return this.save(newArticulo);
        }
    }

    public Boolean deleteById(Integer id) {
    	Optional<Articulo> articulo = articuloRepository.findById(id);
    	Date date = new Date();
    	
    	if (articulo.isPresent()) {
            articulo.get().setIsDeleted(true);
            articulo.get().setDeletionDate(date);
            this.save(articulo.get());
            return true;
        } else {
            // TODO: Esto deberia tirar un error de que no existe el ID de articulo a eliminar
            return false;
        }
    }

    public ArticuloDto getBaseDto() {
    	
    	Articulo newArticulo = new Articulo();
    	Iterable<Rubro> rubroList = rubroRepository.findAll();
        return new ArticuloDto(newArticulo, rubroList);
    }
    
}
