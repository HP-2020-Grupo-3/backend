package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/role")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("/role/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok(roleService.findById(id));
    }
}
