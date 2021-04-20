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
import com.hp2020g3.venidemary.model.EstadoCuentaCorriente;
import com.hp2020g3.venidemary.service.EstadoCuentaCorrienteService;

@RestController
public class EstadoCuentaCorrienteController {
	
	@Autowired
    private EstadoCuentaCorrienteService estadoCuentaCorrienteService;
		
    @GetMapping("/estadoCuentaCorriente")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(estadoCuentaCorrienteService.findAll());
    }

    @GetMapping("/estadoCuentaCorriente/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
    	return ResponseEntity.ok(estadoCuentaCorrienteService.findById(id));
    }
    
    @GetMapping("/estadoCuentaCorriente/new")
    public ResponseEntity getBaseDto() {
        return ResponseEntity.ok(estadoCuentaCorrienteService.getBaseDto());
    }


    @PostMapping("/estadoCuentaCorriente")
    public ResponseEntity save(@RequestBody EstadoCuentaCorriente estadoCuentaCorriente) {
        return ResponseEntity.ok(estadoCuentaCorrienteService.save(estadoCuentaCorriente));
    }

    @PutMapping("/estadoCuentaCorriente")
    ResponseEntity update(@RequestBody EstadoCuentaCorriente newEstadoCuentaCorriente) {
        return ResponseEntity.ok(estadoCuentaCorrienteService.update(newEstadoCuentaCorriente));
    }

    @DeleteMapping("/estadoCuentaCorriente/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
    	estadoCuentaCorrienteService.deleteById(id);
        return ResponseEntity.ok("{}");
    }

}
