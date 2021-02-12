package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.model.Usuario;
import com.hp2020g3.venidemary.service.UsuarioService;
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
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(usuarioService.findByIsDeleted());
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }
    
    @GetMapping("/usuario/new")
    public ResponseEntity getBaseDto() {

        return ResponseEntity.ok(usuarioService.getBaseDto());
    }


    @PostMapping("/usuario")
    public ResponseEntity save(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @PutMapping("/usuario")
    ResponseEntity update(@RequestBody Usuario newUsuario) {
        return ResponseEntity.ok(usuarioService.update(newUsuario));
    }

    @DeleteMapping("/usuario/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
    	usuarioService.deleteById(id);

        return ResponseEntity.ok("{}");
    }

} 
