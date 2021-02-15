package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.model.ComprobantePago;
import com.hp2020g3.venidemary.service.ComprobantePagoService;
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
public class ComprobantePagoController {
	
	@Autowired
    private ComprobantePagoService comprobantePagoService;
		
    @GetMapping("/comprobantePago")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(comprobantePagoService.findAll());
    }

    @GetMapping("/comprobantePago/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
    	return ResponseEntity.ok(comprobantePagoService.findById(id));
    }
    
    @GetMapping("/comprobantePago/new")
    public ResponseEntity getBaseDto() {
        return ResponseEntity.ok(comprobantePagoService.getBaseDto());
    }


    @PostMapping("/comprobantePago")
    public ResponseEntity save(@RequestBody ComprobantePago comprobantePago) {
        return ResponseEntity.ok(comprobantePagoService.save(comprobantePago));
    }

    @PutMapping("/comprobantePago")
    ResponseEntity update(@RequestBody ComprobantePago newComprobantePago) {
        return ResponseEntity.ok(comprobantePagoService.update(newComprobantePago));
    }

    @DeleteMapping("/comprobantePago/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
    	comprobantePagoService.deleteById(id);

        return ResponseEntity.ok("{}");
    }

}