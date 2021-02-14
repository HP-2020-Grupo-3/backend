package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.model.LineaVenta;
import com.hp2020g3.venidemary.service.LineaVentaService;
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
public class LineaVentaController {
	
	@Autowired
    private LineaVentaService lineaVentaService;
		
    @GetMapping("/lineaVenta")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(lineaVentaService.findAll());
    }

    @GetMapping("/lineaVenta/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        //return ResponseEntity.ok(lineaVentaService.findById(id));
    	return ResponseEntity.ok(lineaVentaService.findById(id));
    }
    
    @GetMapping("/lineaVenta/new")
    public ResponseEntity getBaseDto() {

        return ResponseEntity.ok(lineaVentaService.getBaseDto());
    }


    @PostMapping("/lineaVenta")
    public ResponseEntity save(@RequestBody LineaVenta lineaVenta) {
        return ResponseEntity.ok(lineaVentaService.save(lineaVenta));
    }

    @PutMapping("/lineaVenta")
    ResponseEntity update(@RequestBody LineaVenta newLineaVenta) {
        return ResponseEntity.ok(lineaVentaService.update(newLineaVenta));
    }

    @DeleteMapping("/lineaVenta/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
    	lineaVentaService.deleteById(id);

        return ResponseEntity.ok("{}");
    }

}
