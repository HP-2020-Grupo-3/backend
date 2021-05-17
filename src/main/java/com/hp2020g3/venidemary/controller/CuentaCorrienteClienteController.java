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

import com.hp2020g3.venidemary.dto.CuentaCorrienteClienteDto;
import com.hp2020g3.venidemary.model.CuentaCorrienteCliente;
import com.hp2020g3.venidemary.service.CuentaCorrienteClienteService;

@RestController
public class CuentaCorrienteClienteController {
	
	@Autowired
    private CuentaCorrienteClienteService cuentaCorrienteClienteService;
		
    @GetMapping("/cuentaCorrienteCliente")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(cuentaCorrienteClienteService.findAll());
    }
    
    @GetMapping("/cuentaCorrienteCliente/aprobacion")
    public ResponseEntity getAllNotAprobada() {
        return ResponseEntity.ok(cuentaCorrienteClienteService.findAllNotAprobada());
    }

    @GetMapping("/cuentaCorrienteCliente/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
    	return ResponseEntity.ok(cuentaCorrienteClienteService.findById(id));
    }
    
    @GetMapping("/cuentaCorrienteCliente/new")
    public ResponseEntity getBaseDto() {
        return ResponseEntity.ok(cuentaCorrienteClienteService.getBaseDto());
    }


    @PostMapping("/cuentaCorrienteCliente")
    public ResponseEntity save(@RequestBody CuentaCorrienteCliente cuentaCorrienteCliente) {
        return ResponseEntity.ok(cuentaCorrienteClienteService.save(cuentaCorrienteCliente));
    }

    @PutMapping("/cuentaCorrienteCliente")
    ResponseEntity update(@RequestBody CuentaCorrienteClienteDto newCuentaCorrienteCliente) {
        return ResponseEntity.ok(cuentaCorrienteClienteService.update(newCuentaCorrienteCliente));
    }

    @DeleteMapping("/cuentaCorrienteCliente/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
    	cuentaCorrienteClienteService.deleteById(id);
        return ResponseEntity.ok("{}");
    }


}
