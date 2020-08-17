package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

}
