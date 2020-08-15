package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.model.Provincia;
import com.hp2020g3.venidemary.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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


}
