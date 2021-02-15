package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.model.TipoEntrega;
import com.hp2020g3.venidemary.service.TipoEntregaService;
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
public class TipoEntregaController {
	
	@Autowired
    private TipoEntregaService tipoEntregaService;
		
    @GetMapping("/tipoEntrega")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(tipoEntregaService.findAll());
    }

    @GetMapping("/tipoEntrega/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
    	return ResponseEntity.ok(tipoEntregaService.findById(id));
    }
    
    @GetMapping("/tipoEntrega/new")
    public ResponseEntity getBaseDto() {
        return ResponseEntity.ok(tipoEntregaService.getBaseDto());
    }


    @PostMapping("/tipoEntrega")
    public ResponseEntity save(@RequestBody TipoEntrega tipoEntrega) {
        return ResponseEntity.ok(tipoEntregaService.save(tipoEntrega));
    }

    @PutMapping("/tipoEntrega")
    ResponseEntity update(@RequestBody TipoEntrega newTipoEntrega) {
        return ResponseEntity.ok(tipoEntregaService.update(newTipoEntrega));
    }

    @DeleteMapping("/tipoEntrega/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
    	tipoEntregaService.deleteById(id);

        return ResponseEntity.ok("{}");
    }

}
