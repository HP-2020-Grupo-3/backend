package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.model.Rubro;
import com.hp2020g3.venidemary.service.ProvinciaService;
import com.hp2020g3.venidemary.service.RubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RubroController {

    @Autowired
    RubroService rubroService;

    @GetMapping("/rubro")
    public ResponseEntity getAll() {

        return ResponseEntity.ok(rubroService.findAll());
    }

    @GetMapping("/rubro/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok(rubroService.findById(id));
    }

    @PostMapping("/rubro")
    public ResponseEntity save(@RequestBody Rubro rubro) {
        return ResponseEntity.ok(rubroService.save(rubro));
    }

    @PutMapping("/rubro/{id}")
    ResponseEntity update(@RequestBody Rubro newRubro, @PathVariable Integer id) {
        return ResponseEntity.ok(rubroService.update(newRubro, id));
    }

    @DeleteMapping("/rubro/{id}")
    void delete(@PathVariable Integer id) {
        rubroService.deleteById(id);
    }
}
