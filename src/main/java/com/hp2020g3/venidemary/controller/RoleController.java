package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.model.Role;
import com.hp2020g3.venidemary.service.RoleService;
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
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/role")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("/role/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok(roleService.findById(id));
    }
    
    @GetMapping("/role/base")
    public ResponseEntity getBaseDto() {

        return ResponseEntity.ok(roleService.getBaseDto());
    }


    @PostMapping("/role")
    public ResponseEntity save(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.save(role));
    }

    @PutMapping("/role")
    ResponseEntity update(@RequestBody Role newRole) {
        return ResponseEntity.ok(roleService.update(newRole));  
    }

    @DeleteMapping("/role/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
        roleService.deleteById(id);

        return ResponseEntity.ok("{}");
    }
}
