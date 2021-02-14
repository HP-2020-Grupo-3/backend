package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.model.Precio;
import com.hp2020g3.venidemary.service.PrecioService;
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
public class PrecioController {
	
	@Autowired
    private PrecioService precioService;
		
    @GetMapping("/precio")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(precioService.findAll());
    }

    @GetMapping("/precio/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        //return ResponseEntity.ok(precioService.findById(id));
    	return ResponseEntity.ok(precioService.findById(id));
    }
    
    @GetMapping("/precio/new")
    public ResponseEntity getBaseDto() {

        return ResponseEntity.ok(precioService.getBaseDto());
    }


    @PostMapping("/precio")
    public ResponseEntity save(@RequestBody Precio precio) {
        return ResponseEntity.ok(precioService.save(precio));
    }

    @PutMapping("/precio")
    ResponseEntity update(@RequestBody Precio newPrecio) {
        return ResponseEntity.ok(precioService.update(newPrecio));
    }

    @DeleteMapping("/precio/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
    	precioService.deleteById(id);

        return ResponseEntity.ok("{}");
    }

}
