package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.model.Provincia;
import com.hp2020g3.venidemary.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProvinciaController {

    @Autowired
    ProvinciaService provinciaService;

    @GetMapping("/provincia")
    public ResponseEntity getAll() {

        return ResponseEntity.ok(provinciaService.findAll());
    }

    @GetMapping("/provincia/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {

        return ResponseEntity.ok(provinciaService.findById(id));
    }

    @GetMapping("/provincia/base")
    public ResponseEntity getBaseDto() {

        return ResponseEntity.ok(provinciaService.getBaseDto());
    }


    @PostMapping("/provincia")
    public ResponseEntity save(@RequestBody Provincia provincia) {
        return ResponseEntity.ok(provinciaService.save(provincia));
    }

    @PutMapping("/provincia")
    ResponseEntity update(@RequestBody Provincia newProvincia) {
        return ResponseEntity.ok(provinciaService.update(newProvincia));
    }

    @DeleteMapping("/provincia/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
        provinciaService.deleteById(id);

        return ResponseEntity.ok("{}");
    }
}