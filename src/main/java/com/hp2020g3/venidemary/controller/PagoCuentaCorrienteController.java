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
import com.hp2020g3.venidemary.model.PagoCuentaCorriente;
import com.hp2020g3.venidemary.service.PagoCuentaCorrienteService;

@RestController
public class PagoCuentaCorrienteController {
	
	@Autowired
    private PagoCuentaCorrienteService pagoCuentaCorrienteService;
		
    @GetMapping("/pagoCuentaCorriente")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(pagoCuentaCorrienteService.findAll());
    }

    @GetMapping("/pagoCuentaCorriente/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
    	return ResponseEntity.ok(pagoCuentaCorrienteService.findById(id));
    }
    
    @GetMapping("/pagoCuentaCorriente/new")
    public ResponseEntity getBaseDto() {
        return ResponseEntity.ok(pagoCuentaCorrienteService.getBaseDto());
    }


    @PostMapping("/pagoCuentaCorriente")
    public ResponseEntity save(@RequestBody PagoCuentaCorriente pagoCuentaCorriente) {
        return ResponseEntity.ok(pagoCuentaCorrienteService.save(pagoCuentaCorriente));
    }

    @PutMapping("/pagoCuentaCorriente")
    ResponseEntity update(@RequestBody PagoCuentaCorriente newPagoCuentaCorriente) {
        return ResponseEntity.ok(pagoCuentaCorrienteService.update(newPagoCuentaCorriente));
    }

    @DeleteMapping("/pagoCuentaCorriente/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
    	pagoCuentaCorrienteService.deleteById(id);
        return ResponseEntity.ok("{}");
    }
}
