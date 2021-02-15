package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.model.Venta;
import com.hp2020g3.venidemary.service.VentaService;
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
public class VentaController {
	
	@Autowired
    private VentaService ventaService;
		
    @GetMapping("/venta")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(ventaService.findAll());
    }

    @GetMapping("/venta/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
    	return ResponseEntity.ok(ventaService.findById(id));
    }
    
    @GetMapping("/venta/new")
    public ResponseEntity getBaseDto() {
        return ResponseEntity.ok(ventaService.getBaseDto());
    }


    @PostMapping("/venta")
    public ResponseEntity save(@RequestBody Venta venta) {
        return ResponseEntity.ok(ventaService.save(venta));
    }

    @PutMapping("/venta")
    ResponseEntity update(@RequestBody Venta newVenta) {
        return ResponseEntity.ok(ventaService.update(newVenta));
    }

    @DeleteMapping("/venta/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
    	ventaService.deleteById(id);

        return ResponseEntity.ok("{}");
    }

}