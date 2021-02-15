package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.model.Descuento;
import com.hp2020g3.venidemary.service.DescuentoService;
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
public class DescuentoController {
	
	@Autowired
    private DescuentoService descuentoService;
		
    @GetMapping("/descuento")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(descuentoService.findAll());
    }

    @GetMapping("/descuento/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
    	return ResponseEntity.ok(descuentoService.findById(id));
    }
    
    @GetMapping("/descuento/new")
    public ResponseEntity getBaseDto() {
        return ResponseEntity.ok(descuentoService.getBaseDto());
    }


    @PostMapping("/descuento")
    public ResponseEntity save(@RequestBody Descuento descuento) {
        return ResponseEntity.ok(descuentoService.save(descuento));
    }

    @PutMapping("/descuento")
    ResponseEntity update(@RequestBody Descuento newDescuento) {
        return ResponseEntity.ok(descuentoService.update(newDescuento));
    }

    @DeleteMapping("/descuento/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
    	descuentoService.deleteById(id);

        return ResponseEntity.ok("{}");
    }

}