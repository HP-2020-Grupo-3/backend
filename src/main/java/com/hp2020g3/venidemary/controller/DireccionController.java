package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.model.Direccion;
import com.hp2020g3.venidemary.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DireccionController {

    @Autowired
    DireccionService direccionService;

    @GetMapping("/direccion")
    public ResponseEntity getAll() {

        return ResponseEntity.ok(direccionService.findAll());
    }

    @GetMapping("/direccion/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {

        return ResponseEntity.ok(direccionService.findById(id));
    }

    @GetMapping("/direccion/base")
    public ResponseEntity getBaseDto() {

        return ResponseEntity.ok(direccionService.getBaseDto());
    }


    @PostMapping("/direccion")
    public ResponseEntity save(@RequestBody Direccion direccion) {
        return ResponseEntity.ok(direccionService.save(direccion));
    }

    @PutMapping("/direccion")
    ResponseEntity update(@RequestBody Direccion newDireccion) {
        return ResponseEntity.ok(direccionService.update(newDireccion));
    }

    @DeleteMapping("/direccion/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
    	direccionService.deleteById(id);

        return ResponseEntity.ok("{}");
    }
} 