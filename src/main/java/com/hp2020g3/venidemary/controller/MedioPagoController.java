package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.model.MedioPago;
import com.hp2020g3.venidemary.service.MedioPagoService;
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
public class MedioPagoController {
	
	@Autowired
    private MedioPagoService medioPagoService;
		
    @GetMapping("/medioPago")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(medioPagoService.findAll());
    }

    @GetMapping("/medioPago/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
    	return ResponseEntity.ok(medioPagoService.findById(id));
    }
    
    @GetMapping("/medioPago/new")
    public ResponseEntity getBaseDto() {
        return ResponseEntity.ok(medioPagoService.getBaseDto());
    }


    @PostMapping("/medioPago")
    public ResponseEntity save(@RequestBody MedioPago medioPago) {
        return ResponseEntity.ok(medioPagoService.save(medioPago));
    }

    @PutMapping("/medioPago")
    ResponseEntity update(@RequestBody MedioPago newMedioPago) {
        return ResponseEntity.ok(medioPagoService.update(newMedioPago));
    }

    @DeleteMapping("/medioPago/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
    	medioPagoService.deleteById(id);

        return ResponseEntity.ok("{}");
    }

}