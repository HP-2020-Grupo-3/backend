package com.hp2020g3.venidemary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hp2020g3.venidemary.model.LineaVentaCuentaCorriente;
import com.hp2020g3.venidemary.service.LineaVentaCuentaCorrienteService;

@RestController
public class LineaVentaCuentaCorrienteController {
	
	@Autowired
    private LineaVentaCuentaCorrienteService lineaVentaCuentaCorrienteService;
		
    @GetMapping("/lineaVentaCuentaCorrienteCliente")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(lineaVentaCuentaCorrienteService.findAll());
    }

    @GetMapping("/lineaVentaCuentaCorrienteCliente/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
    	return ResponseEntity.ok(lineaVentaCuentaCorrienteService.findById(id));
    }
    
    @GetMapping("/lineaVentaCuentaCorriente/new")
    public ResponseEntity getBaseDto() {
        return ResponseEntity.ok(lineaVentaCuentaCorrienteService.getBaseDto());
    }


    @PostMapping("/lineaVentaCuentaCorriente")
    public ResponseEntity save(@RequestBody LineaVentaCuentaCorriente lineaVentaCuentaCorriente) {
        return ResponseEntity.ok(lineaVentaCuentaCorrienteService.save(lineaVentaCuentaCorriente));
    }

    @PutMapping("/lineaVentaCuentaCorriente")
    ResponseEntity update(@RequestBody LineaVentaCuentaCorriente newlineaVentaCuentaCorriente) {
        return ResponseEntity.ok(lineaVentaCuentaCorrienteService.update(newlineaVentaCuentaCorriente));
    }

    @DeleteMapping("/lineaVentaCuentaCorriente/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
    	lineaVentaCuentaCorrienteService.deleteById(id);
        return ResponseEntity.ok("{}");
    }


}
