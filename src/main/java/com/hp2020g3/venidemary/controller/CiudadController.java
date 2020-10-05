package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.model.Ciudad;
import com.hp2020g3.venidemary.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CiudadController {

    @Autowired
    CiudadService ciudadService;

    @GetMapping("/ciudad")
    public ResponseEntity getAll() {

        return ResponseEntity.ok(ciudadService.findAll());
    }

    @GetMapping("/ciudad/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {

        return ResponseEntity.ok(ciudadService.findById(id));
    }

    @GetMapping("/ciudad/base")
    public ResponseEntity getBaseDto() {

        return ResponseEntity.ok(ciudadService.getBaseDto());
    }


    @PostMapping("/ciudad")
    public ResponseEntity save(@RequestBody Ciudad ciudad) {
        return ResponseEntity.ok(ciudadService.save(ciudad));
    }

    @PutMapping("/ciudad")
    ResponseEntity update(@RequestBody Ciudad newCiudad) {
        return ResponseEntity.ok(ciudadService.update(newCiudad));
    }

    @DeleteMapping("/ciudad/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
        ciudadService.deleteById(id);

        return ResponseEntity.ok("{}");
    }
}