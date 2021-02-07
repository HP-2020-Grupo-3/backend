package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.model.Rubro;
import com.hp2020g3.venidemary.service.RubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_EMPLOYEE')")
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

    @GetMapping("/rubro/base")
    public ResponseEntity getBaseDto() {

        return ResponseEntity.ok(rubroService.getBaseDto());
    }


    @PostMapping("/rubro")
    public ResponseEntity save(@RequestBody Rubro rubro) {
        return ResponseEntity.ok(rubroService.save(rubro));
    }

    @PutMapping("/rubro")
    ResponseEntity update(@RequestBody Rubro newRubro) {
        return ResponseEntity.ok(rubroService.update(newRubro));
    }

    @DeleteMapping("/rubro/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
        rubroService.deleteById(id);

        return ResponseEntity.ok("{}");
    }
}
