package com.hp2020g3.venidemary.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.hp2020g3.venidemary.exception.EntityNotFoundException;
import com.hp2020g3.venidemary.model.Precio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp2020g3.venidemary.dto.ArticuloDto;
import com.hp2020g3.venidemary.model.Articulo;
import com.hp2020g3.venidemary.model.Rubro;
import com.hp2020g3.venidemary.repository.ArticuloRepository;

@Service
public class ArticuloService {
	
	
	@Autowired
	private ArticuloRepository articuloRepository;
	
	@Autowired
	private RubroService rubroService;
	
	public Iterable<Articulo> findAll() {
        
        return articuloRepository.findAll();
                        
    }
    
    public Iterable<ArticuloDto> findAllByIsDeleted() {
    	
    	Iterable<Articulo> validArticles = articuloRepository.findAllByIsDeleted(false);
        Iterable<Rubro> rubros = rubroService.findAll();
    	return StreamSupport.stream(validArticles.spliterator(), false)
                .map(articulo -> new ArticuloDto(articulo, rubros))
                .collect(Collectors.toList());
    }

    public Optional<Articulo> findById(Integer id) {
        return articuloRepository.findById(id);
    	
    }
    
    public ArticuloDto findArticuloDtoById(Integer id) {
        Optional<Articulo> articulo = articuloRepository.findById(id);

        if (articulo.isPresent()) {
    	    return new ArticuloDto(articulo.get(), rubroService.findAll());
        } else {
            throw new EntityNotFoundException(String.format("El articulo %d no existe.", id));
        }
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
        Precio precio = new Precio(articuloDto.getPrecio(), articulo);

        articulo.setPrecio(precio);

		return new ArticuloDto(articuloRepository.save(articulo), rubroService.findAll());
    }
	
    public ArticuloDto update(ArticuloDto articuloDto) {
        Optional<Articulo> articulo =  this.findById(articuloDto.getId());

        if (!articulo.isPresent()) {
            throw new EntityNotFoundException("El articulo que intenta actualizar no existe.");
        }

        if (articulo.get().getPrecio().getValor() != articuloDto.getPrecio()) {
            Precio precio = new Precio(articuloDto.getPrecio(), articulo.get());
            articulo.get().setPrecio(precio);
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
    	
    	Optional<Rubro> rubro = rubroService.getDefault();
    	Articulo newArticulo = new Articulo();
    	if (rubro.isPresent()) {
    		newArticulo.setRubro(rubro.get());
    	}
    	Iterable<Rubro> rubroList = rubroService.findAll();

    	return new ArticuloDto(newArticulo, rubroList);
    }
    
}
