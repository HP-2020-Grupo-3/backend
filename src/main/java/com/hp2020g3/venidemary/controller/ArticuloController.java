package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.dto.ArticuloDto;
import com.hp2020g3.venidemary.model.Articulo;
import com.hp2020g3.venidemary.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticuloController {
	
	@Autowired
    private ArticuloService articuloService;
	
    @GetMapping("/articulo")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(articuloService.findAllByIsDeleted());
    }

    @GetMapping("/articulo/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        //return ResponseEntity.ok(articuloService.findById(id));
    	return ResponseEntity.ok(articuloService.findArticuloDtoById(id));
    }
    
    @GetMapping("/articulo/new")
    public ResponseEntity getBaseDto() {

        return ResponseEntity.ok(articuloService.getBaseDto());
    }


    @PostMapping("/articulo")
    public ResponseEntity save(@RequestBody ArticuloDto articulo) {
        return ResponseEntity.ok(articuloService.save(articulo));
    }

    @PutMapping("/articulo")
    ResponseEntity update(@RequestBody ArticuloDto articuloDto) {
        return ResponseEntity.ok(articuloService.update(articuloDto));
    }

    @DeleteMapping("/articulo/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
    	articuloService.deleteById(id);

        return ResponseEntity.ok("{}");
    }
	    
}
