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

        
	public ArticuloDto save(ArticuloDto articuloDto) {

	    Optional<Rubro> rubro = null;
	    if (articuloDto.getCurrentRubro() != null) {
            rubro = rubroService.findById(articuloDto.getCurrentRubro().getId());
        }

	    if (rubro == null || !rubro.isPresent()) {
            rubro = rubroService.getDefault();
        }
	    Articulo articulo = new Articulo(articuloDto, rubro.get());

		return new ArticuloDto(articuloRepository.save(articulo), rubroRepository.findAll());
    }
	
    public ArticuloDto update(ArticuloDto articuloDto) {
        Optional<Articulo> articulo =  this.findById(articuloDto.getId());

        if (!articulo.isPresent()) {
            // TODO: Esto deberia tirar un error de que rubro que intetas actuializar no existe.
            articuloDto.setId(null);
        }

        return this.save(articuloDto);
    }

    public Boolean deleteById(Integer id) {
    	Optional<Articulo> articulo = articuloRepository.findById(id);
    	Date date = new Date();
    	
    	if (articulo.isPresent()) {
            articulo.get().setIsDeleted(true);
            articulo.get().setDeletionDate(date);
            this.articuloRepository.save(articulo.get());

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
